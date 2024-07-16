package org.example.consultation.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "logginServlet", value = "/login")
public class LogginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        login(req, resp);
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setAttribute("isLogged", true);
        String redirectUrl = (String) session.getAttribute("redirectUrl");

        if (redirectUrl != null && !redirectUrl.isEmpty()) {
            session.removeAttribute("redirectUrl");
            resp.sendRedirect(redirectUrl);
        } else {
            resp.sendRedirect(req.getContextPath()+"/");
        }
    }
}

