package org.example.consultation.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.consultation.service.DoctorService;
import org.example.consultation.service.PatientService;

import java.io.File;
import java.io.IOException;

@WebServlet(name = "patientServlet", value = "/patient/*")
@MultipartConfig(maxFileSize = 16177215)
public class PatientServlet extends HttpServlet {

    private final PatientService patientService = new PatientService();
    private final DoctorService doctorService = new DoctorService();


    @Override
    public void init() throws ServletException {
//       doctorService.addDoctor(new Doctor("Doe"));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        // on check si path info n'est pas vide et si il est existant alors on pathInfo sinon on met vide
        pathInfo = pathInfo != null ? pathInfo : "";
        System.out.println(pathInfo);
        redirectSystem(req, resp, pathInfo);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pathInfo = req.getPathInfo().substring(1);
        redirectSystem(req, resp, pathInfo);
    }

    private void listPatients(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        if (checkLogin(req, resp)) {
            req.setAttribute("patients", patientService.listPatients());
            req.getRequestDispatcher("/WEB-INF/patient-list.jsp").forward(req, resp);
        } else {
            HttpSession session = req.getSession();
            String originalUrl = req.getRequestURI();
            session.setAttribute("redirectUrl", originalUrl); // Store original URL in session
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    private void addPatient(HttpServletRequest req, HttpServletResponse resp) {
        String method = req.getMethod();

        if (!checkLogin(req, resp)) {
            try {
                HttpSession session = req.getSession();
                String originalUrl = req.getRequestURI();
                System.out.println(originalUrl);
                session.setAttribute("redirectUrl", originalUrl);
                resp.sendRedirect(req.getContextPath() + "/login");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        switch (method) {
            case "GET":
                try {
                    req.setAttribute("doctorList", doctorService.getDoctorList());
                    req.setAttribute("mode", "ADD");
                    req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "POST":
                String firstName = req.getParameter("firstName");
                String lastName = req.getParameter("lastName");
                String birthDate = req.getParameter("birthDate");
                String doctorId = req.getParameter("doctorId");
                String imgName = req.getParameter("imgName");

                patientService.addPatient(firstName, lastName, birthDate, doctorId,imgName);
                try {
                    resp.sendRedirect(req.getContextPath() + "/patient/list");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                try {
                    resp.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void deletePatient(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        patientService.deletePatient(id);
        try {
            resp.sendRedirect(req.getContextPath() + "/patient/list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void editPatient(HttpServletRequest req, HttpServletResponse resp) {
        String method = req.getMethod();
        int id = Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        switch (method) {
            case "GET":
                try {
                    req.setAttribute("patient", patientService.getPatientById(id));
                    req.setAttribute("doctorList", doctorService.getDoctorList());
                    req.setAttribute("mode", "EDIT");
                    req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case "POST":
                String firstName = req.getParameter("firstName");
                String lastName = req.getParameter("lastName");
                String birthDate = req.getParameter("birthDate");
                String doctorId = req.getParameter("doctorId");
                String imgName = req.getParameter("imgName");
                patientService.updatePatient(firstName, lastName, birthDate, doctorId,imgName);
                try {
                    resp.sendRedirect(req.getContextPath() + "/patient/list");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void detailPatient(HttpServletRequest req, HttpServletResponse resp) {
        String id = req.getParameter("id");
        try {
            req.setAttribute("patient", patientService.getPatientById(Integer.parseInt(id)));
            req.setAttribute("doctorList", doctorService.getDoctorList());
            req.setAttribute("mode", "DETAIL");
            req.getRequestDispatcher("/WEB-INF/form.jsp").forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private boolean registerImage(String imgName) {
        String uploadPath = getServletContext().getRealPath("/") + "images";

        File file = new File(uploadPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        // TODO Finir ajout d'image
        return false;
    }


    private boolean checkLogin(HttpServletRequest req, HttpServletResponse resp) {
        boolean isLoggedIn = false;
        HttpSession session = req.getSession();
        if (session.getAttribute("isLogged") != null) {
            isLoggedIn = (boolean) session.getAttribute("isLogged");
        }
        return isLoggedIn;
    }

    private void redirectSystem(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
        switch (path) {
            case "list" -> listPatients(req, resp);
            case "add" -> addPatient(req, resp);
            case "delete" -> deletePatient(req, resp);
            case "edit" -> editPatient(req, resp);
            case "detail" -> detailPatient(req, resp);
            default -> resp.sendRedirect(req.getContextPath() + "/");
        }
    }


}
