package com.week4;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@WebServlet(name="ConfitDemoServlet",value="/confit",
        initParams={
                @WebInitParam(name="name",value="YuPengxiu"),
                @WebInitParam(name="studentid",value="2020211001001303"),
        }
)
public class ConfigDemoServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletConfig Config = getServletConfig();
        String name = Config.getInitParameter("name");
        String studentid = Config.getInitParameter("studentid");
        PrintWriter writer = response.getWriter();
        System.out.println(1);//test
        writer.println("name:"+name);
        writer.println("studentid:"+studentid);

    }
}