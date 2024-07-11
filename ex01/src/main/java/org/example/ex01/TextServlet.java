package org.example.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "textServlet", value = "/textServlet")
public class TextServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("TextServlet doGet");
        resp.setContentType("text/plain");

        PrintWriter writer = resp.getWriter();
        writer.println("Hello World!");

    }

    @Override
    public void destroy() {

    }
}
