package org.example.formulaire.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.formulaire.model.Cat;
import org.example.formulaire.model.CatRace;
import org.example.formulaire.model.FoodType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/form-servlet")
public class FormServlet extends HttpServlet {
    private List<Cat> catList = new ArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/formulaire.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nom = req.getParameter("name");
        LocalDate birthDate = LocalDate.parse(req.getParameter("birthdate"));
        CatRace catRace = CatRace.valueOf(req.getParameter("race").toUpperCase());
        FoodType foodType = FoodType.valueOf(req.getParameter("foodtype").toUpperCase());
        Cat cat = new Cat(nom, birthDate, catRace, foodType);
        catList.add(cat);
        req.setAttribute("catList", catList);
        req.getRequestDispatcher("/WEB-INF/cat-list.jsp").forward(req, resp);
    }

}
