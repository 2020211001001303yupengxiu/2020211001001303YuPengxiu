package com.week6;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String search = request.getParameter("search");
        if(text.length()==0){
            response.sendRedirect("index.jsp");
        }
        else{
            if(search.equals("baidu")){
                response.sendRedirect("https://www.baidu.com/s?wd="+text);
            }else if (search.equals("bing")){
                response.sendRedirect("https://cn.bing.com/search?q="+text);
            }else if (search.equals("google")){
                response.sendRedirect("https://www.google.com/search?q="+text);
            }
        }
    }
}
