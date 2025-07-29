package org.app.exo2.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.app.exo2.model.Person;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "personController", value = "/personList")
public class PersonController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        super.init();
    }

     @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         List<Person> personList = List.of(
                 new Person("Mark", "Otto", 20),
                 new Person("Jacob", "Thornton", 25),
                 new Person("Larry", "Bird", 47)
         );

         request.setAttribute("personList", personList);
         request.getRequestDispatcher("/view/listPerson.view.jsp").forward(request, response);
     }
}


