package org.app.exo3.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.exo3.models.Cat;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "catServlet", value = "/catList")
public class GetCatServlet extends HttpServlet {

    public List<Cat> catList;

    public void init() {
        catList = List.of(
                new Cat(1L, "Whiskers", "Fish", LocalDate.now()),
                new Cat(2L, "Mittens", "Chicken", LocalDate.now())
        );
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setAttribute("catList", catList);
        request.getRequestDispatcher("/views/catList.jsp").forward(request, response);
    }
}
