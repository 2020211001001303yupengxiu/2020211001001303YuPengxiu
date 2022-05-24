package com.controllar;

import com.dao.UserDao;
import com.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    Connection con = null;
    @Override
    public void init() throws ServletException {
        super.init();
        con = (Connection) getServletContext().getAttribute("con");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("Email");
        String gender = request.getParameter("sex");
        String birth = request.getParameter("birth");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setGender(gender);
        user.setBirth(birth);
        UserDao userDao = new UserDao();
        int update = 0;
        try {
            update = userDao.updateUser(con,user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (update == 0) {
            //HttpSession session = request.getSession();//create session if session not exist -- otherwise return existing session
            session.setMaxInactiveInterval(10);

            //ange request(one page) to session -- can get session attribute in many jsp
            session.setAttribute("user",user);
            request.getRequestDispatcher("accountDetails").forward(request,response);
        }
        else {
            request.setAttribute("updateFail","updateUser fail!");
            request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }
}
