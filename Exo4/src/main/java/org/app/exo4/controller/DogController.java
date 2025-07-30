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
                String editId = request.getParameter("id");
                if (editId != null) {

                        Dog dogToEdit = DogService.getInstance().findById(Long.parseLong(editId));
                        if (dogToEdit != null) {
                            request.setAttribute("dog", dogToEdit);
                            request.getRequestDispatcher("/views/dogForm.jsp").forward(request, response);
                        } else {
                            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Chien non trouvé.");
                        }
                    } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'ID n'a pas été trouvé");
                }
                break;
            case "/dogDelete":
                String dogId = request.getParameter("id");
                if (dogId != null) {
                    DogService.getInstance().delete(Long.parseLong(dogId));
                    response.sendRedirect(request.getContextPath() + "/dogList");
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'ID n'a pas été trouvé");
                }
                break;
            case "/dog":
                String pathInfo = request.getPathInfo();
                if (pathInfo != null && pathInfo.length() > 1) {
                    String id = pathInfo.substring(1);

                    Dog dog = DogService.getInstance().findById(Long.parseLong(id));
                    if (dog != null) {
                        request.setAttribute("dog", dog);
                        request.getRequestDispatcher("/views/dogDetail.jsp").forward(request, response);
                    } else {
                        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Chien non trouvé.");
                    }
                } else {
                    response.sendError(HttpServletResponse.SC_BAD_REQUEST, "L'ID n'a pas été trouvé");
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
            String idParam = request.getParameter("id");
            String name = request.getParameter("name");
            String breed = request.getParameter("breed");
            LocalDate birthDate = LocalDate.parse(request.getParameter("birthDate"));

            if (idParam != null && !idParam.isEmpty()) {
                // Modification d'un chien existant
                Long id = Long.parseLong(idParam);
                Dog dog = DogService.getInstance().findById(id);
                if (dog != null) {
                    dog.setName(name);
                    dog.setBreed(breed);
                    dog.setBirthDate(birthDate);
                    DogService.getInstance().save(dog);
                }
            } else {
                // Création d'un nouveau chien
                Dog dog = new Dog(name, breed, birthDate);
                DogService.getInstance().save(dog);
            }

            response.sendRedirect(request.getContextPath() + "/dogList");
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }




}
