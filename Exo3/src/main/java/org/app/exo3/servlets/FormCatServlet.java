package org.app.exo3.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.exo3.models.Cat;
import org.app.exo3.repository.ServiceCatBdd;
import org.app.exo3.services.ICatService;
import org.app.exo3.utils.HibernateSession;

import java.io.IOException;
import java.time.LocalDate;


@WebServlet(name = "formCatServlet", value = "/catForm")
public class FormCatServlet extends HttpServlet {

    private ICatService catService;

    @Override
    public void init() {
        catService = new ServiceCatBdd(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/views/catForm.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String race = request.getParameter("race");
        String favoriteFood = request.getParameter("favoriteFood");
        LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));

        Cat cat = new Cat(name, race, favoriteFood, birthDate);
        System.out.println("Cat created: " + cat);
        catService.addCat(cat);

        response.sendRedirect(request.getContextPath() + "/catList");

    }
}
