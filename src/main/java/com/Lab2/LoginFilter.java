package com.Lab2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName="LoginFilter",
        urlPatterns={"/lab2/validation.jsp","/lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        System.out.println("i am in LoginFilter--init()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain Chain) throws IOException, ServletException {
        System.out.println("i am in LoginFilter--doFilter--doFilter()--request before chain");
        HttpServletRequest req =(HttpServletRequest) request;
        HttpServletResponse res =(HttpServletResponse) response;
        HttpSession session=req.getSession(false);
        if(session != null && session.getAttribute("login")!=null){
            req.getRequestDispatcher("/lab2/welcome.jsp").forward(request,response);
        }else{
            res.sendRedirect("login.jsp");
            return;
        }
        Chain.doFilter(request,response);
        System.out.println("i am in LoginFilter--doFilter()--response after chain");
    }

    @Override
    public void destroy() {
        System.out.println("i am in LoginFilter--destory()");
    }
}
