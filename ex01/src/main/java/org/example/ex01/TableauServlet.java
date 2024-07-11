package org.example.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "tableauServlet", value = "/tableau")
public class TableauServlet extends HttpServlet {

    private List<User> users;

    @Override
    public void init() throws ServletException {
        users = List.of(
                new User("John", "Doe,", 25),
                new User("Jane", "Doe,", 30),
                new User("Alice", "Bob,", 35)
        );
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", users);
        req.getRequestDispatcher("/dataInJsp/tableau.jsp").forward(req, resp);
    }
}
