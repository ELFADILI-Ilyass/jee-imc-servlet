package com.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/CalculDeMonImc")
public class CalculDeMonlmc extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        String poidsStr = request.getParameter("poids");
        String tailleStr = request.getParameter("taille");

        out.println("<!DOCTYPE html><html><head><meta charset='utf-8'><title>IMC</title></head><body>");
        out.println("<h1>Calcul IMC</h1>");

        try {
            double poids = Double.parseDouble(poidsStr);
            double taille = Double.parseDouble(tailleStr);

            double imc = poids / (taille * taille);

            out.println("<p>Poids: " + poids + " kg</p>");
            out.println("<p>Taille: " + taille + " m</p>");
            out.println("<h2>IMC = " + String.format("%.2f", imc) + "</h2>");

        } catch (Exception e) {
            out.println("<p style='color:red'>Erreur: paramètres invalides.</p>");
            out.println("<p>Exemple: /CalculDeMonImc?poids=94&taille=1.86</p>");
        }

        out.println("</body></html>");
    }
    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    
    
}
