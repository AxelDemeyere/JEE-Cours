package org.app.exo2.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.exo2.model.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addPersonController", value = "/addPerson")
public class AddPersonController extends HttpServlet {
    private static final List<Person> personList = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/view/addPerson.view.jsp").forward(request, response);
    }

}