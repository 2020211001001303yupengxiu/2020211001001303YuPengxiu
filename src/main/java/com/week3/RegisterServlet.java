package com.week3;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns={"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    PreparedStatement ps= null;
    ResultSet rs = null;
    @Override
    public void init() throws ServletException {
        super.init();
        /*ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {*//*String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        String username="sa";
        String password="123";*//*
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/
         con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Email = request.getParameter("email");
        String Gender = request.getParameter("gender");
        String birth = request.getParameter("birth");

        /*PrintWriter writer = response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        writer.println("<br>Email :"+Email);
        writer.println("<br>Gender :"+Gender);
        writer.println("<br>birth :"+birth);
        writer.close();*/
        String sql1 = " insert into usertable(username,password,email,sex,birth) values (?,?,?,?,?) ";
        String sql2 = " select* from usertable ";
        PrintWriter writer = response.getWriter();
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,Email);
            ps.setString(4,Gender);
            ps.setString(5,birth);
            ps.executeUpdate();
            response.sendRedirect("login");
/*            ps = con.prepareStatement(sql2);
            ps.executeQuery();
            rs=ps.executeQuery();
            writer.println("<table border=1> <tr> <th>id</th> <th>username</th> <th>password</th> <th>email</th>" +
                    "<th>gender</th> <th>birthdate</th> </tr>" );
            while (rs.next()){
                writer.println("<tr> <th>"+rs.getString("id")+"</th> ");
                writer.println(" <th>"+rs.getString("username")+"</th> ");
                writer.println(" <th>"+rs.getString("password")+"</th> ");
                writer.println(" <th>"+rs.getString("email")+"</th> ");
                writer.println(" <th>"+rs.getString("sex")+"</th> ");
                writer.println(" <th>"+rs.getString("birth")+"</th></tr>");
            }
            writer.println("</table>");*/

        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("fail","register fail!");
            request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }
       destroy();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);
    }
    @Override
    public void destroy() {
        super.destroy();
        try {
            if(rs!=null){
                rs.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
