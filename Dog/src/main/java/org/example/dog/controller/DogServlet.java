package org.example.dog.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dog.entity.Dog;
import org.example.dog.entity.DogRace;
import org.example.dog.repositories.DogRepository;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "DogServlet", urlPatterns = {"/dog", "/dog/detail", "/dog-list"})
public class DogServlet extends HttpServlet {

    private static final String DOG_LIST_PATH = "/dog-list";
    private static final String DOG_PATH = "/dog";
    private static final String DOG_ATTRIBUTE = "dog";
    private static final String DOG_BY_ID = "/dog/detail";
    private static final String ERROR_ATTRIBUTE = "error";
    private static final String DOGS_ATTRIBUTE = "dogs";
    private static final String DOG_JSP = "/WEB-INF/dog.jsp";
    private static final String DOG_LIST_JSP = "/WEB-INF/dog-list.jsp";
    private static final String ERROR_JSP = "/WEB-INF/error.jsp";

    private final DogRepository dogRepository = new DogRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals(DOG_BY_ID) && req.getParameter("id") != null) {
            DogById(req, resp);
        } else {
            OtherDog(req, resp, path);
        }
    }

    private void DogById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String idParam = req.getParameter("id");
            if (idParam == null) {
                throw new NumberFormatException("ID parameter is missing");
            }
            int id = Integer.parseInt(idParam);
            Dog dog = dogRepository.getDogById(id);
            if (dog != null) {
                req.setAttribute(DOG_ATTRIBUTE, dog);
                req.getRequestDispatcher(DOG_JSP).forward(req, resp);
            } else {
                req.setAttribute(ERROR_ATTRIBUTE, "Dog not found");
                req.getRequestDispatcher(ERROR_JSP).forward(req, resp);
            }
        } catch (NumberFormatException e) {
            req.setAttribute(ERROR_ATTRIBUTE, "Invalid dog ID");
            req.getRequestDispatcher(ERROR_JSP).forward(req, resp);
        }
    }

    private void OtherDog(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
        switch (path) {
            case DOG_LIST_PATH:
                req.setAttribute(DOGS_ATTRIBUTE, dogRepository.getAllDogs());
                req.getRequestDispatcher(DOG_LIST_JSP).forward(req, resp);
                break;
            case DOG_PATH:
                req.getRequestDispatcher(DOG_JSP).forward(req, resp);
                break;
            default:
                req.getRequestDispatcher(ERROR_JSP).forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Dog dog = new Dog();
        try {
            dog.setName(req.getParameter("name"));
            dog.setBirthDate(LocalDate.parse(req.getParameter("birthdate")));
            dog.setDogRace(DogRace.valueOf(req.getParameter("race")));
            if (dogRepository.saveDog(dog)) {
                resp.sendRedirect(req.getContextPath() + DOG_LIST_PATH);
            } else {
                System.out.println("Error saving dog");
            }
        } catch (Exception e) {
            resp.getWriter().println("Error saving dog: " + e.getMessage());
        }
    }
}
