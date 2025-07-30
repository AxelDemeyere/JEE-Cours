package org.app.exo3.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.exo3.dao.CatDAO;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "addCatServlet", value = "/addCat")
public class AddCatServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String favoriteFood = request.getParameter("favoriteFood");
        String birthDate = request.getParameter("birthDate");


        CatDAO catDAO = new CatDAO();
        try {
            catDAO.addCat(name, favoriteFood, birthDate);
            response.sendRedirect("catList");
        } catch (SQLException e) {
            throw new ServletException("Erreur lors de l'ajout du chat en base de données", e);
        }
    }
}
