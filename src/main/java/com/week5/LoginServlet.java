package com.week5;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String sql1 = " SELECT * FROM usertable where username=? and password=?";
        PrintWriter writer = response.getWriter();
        try {
            ps = con.prepareStatement(sql1);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.executeQuery();
            rs=ps.executeQuery();
            if (rs.next()){
                writer.println("<h1>Login Success!</h1>");
                writer.println("<h1>Welcome,"+rs.getString("username")+"</h1>");
            }
            else
                writer.println("<h1>Wrong username or password!</h1>");
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
