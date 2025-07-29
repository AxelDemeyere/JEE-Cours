package org.app.exo1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "secondServlet", value = "/second-servlet")
public class SecondServlet extends HttpServlet {

     public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
         request.setAttribute("title", "Second Servlet");
         response.setContentType("text/html");
         PrintWriter out = response.getWriter();
         out.println("<html>");
         out.println("<head><title>Second Servlet</title></head>");
         out.println("<body>");
         out.println("<h1>Second servlet</h1>");
         out.println("</body>");
         out.println("</html>");
     }
}
