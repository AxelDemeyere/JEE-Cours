package org.app.exo3.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.exo3.repository.ServiceCatBdd;
import org.app.exo3.services.ICatService;
import org.app.exo3.utils.HibernateSession;

import java.io.IOException;


@WebServlet(name = "catServlet", value = "/catList")
public class CatServlet extends HttpServlet {

    private ICatService catService;

    @Override
    public void init() {
        catService = new ServiceCatBdd(HibernateSession.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("cats", catService.getAllCats());
        request.getRequestDispatcher("/views/catList.jsp").forward(request, response);
    }
}
