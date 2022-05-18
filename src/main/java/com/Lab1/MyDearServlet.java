package com.Lab1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/myDear")
public class MyDearServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String Class = request.getParameter("class");
        String ID = request.getParameter("ID");
        /*PrintWriter writer = response.getWriter();
        writer.println("<br>name :"+name);
        writer.println("<br>class :"+Class);
        writer.println("<br>ID :"+ID);*/
        request.getRequestDispatcher("WEB-INF/views/MyJsp.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
