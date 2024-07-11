package org.example.formulaire.controller;

import org.example.formulaire.model.Cat;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name="list", value = "/cat-list")
public class ListServlet extends HttpServlet {
    private List<Cat> catList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("catList", catList);
        req.getRequestDispatcher("/WEB-INF/cat-list.jsp").forward(req, resp);
    }
}
