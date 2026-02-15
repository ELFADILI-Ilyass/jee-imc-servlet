package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import com.metier.Imc;

@WebServlet("/CalculDeMonImcTP4")
public class CalculDeMonImc extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String poidsStr = request.getParameter("poids");
        String tailleStr = request.getParameter("taille");

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='utf-8'>");
        out.println("<title>IMC</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Calcul IMC</h1>");

        try {
            double poids = Double.parseDouble(poidsStr);
            double taille = Double.parseDouble(tailleStr);

            // Create object from metier class
            Imc imcObj = new Imc(taille, poids);
            double result = imcObj.calcul();

            out.println("<p>Poids: " + poids + " kg</p>");
            out.println("<p>Taille: " + taille + " m</p>");
            out.println("<h2>IMC = " + String.format("%.2f", result) + "</h2>");

        } catch (Exception e) {
            out.println("<p style='color:red'>Erreur : paramètres invalides.</p>");
            out.println("<p>Exemple : /CalculDeMonImc?poids=94&taille=1.86</p>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doGet(request, response);
    }
}
