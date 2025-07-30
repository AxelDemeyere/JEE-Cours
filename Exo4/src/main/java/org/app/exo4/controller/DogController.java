package org.app.exo4.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.exo4.models.Dog;
import org.app.exo4.service.DogService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name = "dogController", value = {"/dogList", "/dogForm", "/dogEdit", "/dogDelete", "/dogSave", "/dog/*"})
public class DogController extends HttpServlet {

    @Override
    public void init() {
        DogService dogService = new DogService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/dogList":
                request.setAttribute("dogs", DogService.getInstance().findAll());
                request.getRequestDispatcher("/views/dogList.jsp").forward(request, response);
                break;
            case "/dogForm":
                request.getRequestDispatcher("/views/dogForm.jsp").forward(request, response);
                break;
            case "/dogEdit":
                request.getRequestDispatcher("/views/dogEdit.jsp").forward(request, response);
                break;
            case "/dogDelete":
                String dogId = request.getParameter("id");
                if (dogId != null) {
                    DogService.getInstance().delete(Long.parseLong(dogId));
                    response.sendRedirect(request.getContextPath() + "/dogList");
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Dog ID is required for deletion.");
                }
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        if (path.equals("/dogSave")) {
            String name = request.getParameter("name");
            String breed = request.getParameter("breed");
            LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));


            Dog dog = new Dog(name, breed, birthDate);

            DogService.getInstance().save(dog);
            response.sendRedirect(request.getContextPath() + "/dogList");

        } else if (path.startsWith("/dog/")) {
            // Handle other dog-related POST requests
            String dogId = path.substring(5); // Extract the dog ID from the path
            // Logic to handle specific dog actions based on ID
            response.sendRedirect(request.getContextPath() + "/dogList");

        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }


    }




}
