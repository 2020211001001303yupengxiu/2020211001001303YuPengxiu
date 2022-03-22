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
        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");
        try {/*String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        String username="sa";
        String password="123";*/
            Class.forName(driver);
            con = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String Email = request.getParameter("Email");
        String Gender = request.getParameter("sex");
        String birth = request.getParameter("birth");

        /*PrintWriter writer = response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        writer.println("<br>Email :"+Email);
        writer.println("<br>Gender :"+Gender);
        writer.println("<br>birth :"+birth);
        writer.close();*/
        String sql1 = " insert into usertable values (?,?,?,?,?,?) ";
        String sql2 = " select* from usertable ";
        PrintWriter writer = response.getWriter();
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1,id);
            ps.setString(2,username);
            ps.setString(3,password);
            ps.setString(4,Email);
            ps.setString(5,Gender);
            ps.setString(6,birth);
            ps.executeUpdate();
            ps = con.prepareStatement(sql2);
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
            writer.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
       destroy();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    @Override
    public void destroy() {
        super.destroy();
        try {
            rs.close();
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
