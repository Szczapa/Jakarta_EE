package org.example.ex01;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "htmlServlet", urlPatterns = "/htmlServlet")
public class HtmlServlet extends HttpServlet{
    private String prenom;

    @Override
    public void init() throws ServletException {
        System.out.println("HtmlServlet init");
        prenom = "Jhon";
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<html><body>");
        writer.println("<h1>Je renvoie du texte simple !!!!!</h1>");
        writer.println("<h2>Bonjour "+prenom+"!!!!!</h2>");
        writer.println("<a href=\"/ex01_war_exploded/\"> retour </a>    ");
        writer.println("</body></html>");

    }
}
