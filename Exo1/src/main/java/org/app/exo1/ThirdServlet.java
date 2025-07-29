package org.app.exo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "thirdServlet", value = "/third-servlet")
public class ThirdServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", "Troisième Servlet via fragment");
        request.setAttribute("message", "Troisième servlet via setAttribute");
        request.getRequestDispatcher("thirdservlet.jsp").forward(request, response);
    }
}
