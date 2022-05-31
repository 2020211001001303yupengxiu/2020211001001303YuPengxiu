package com.Lab3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CalServlet")
public class CalServlet extends HttpServlet {
    private int add(int first,int second){
        return first+second;
    }
    private int subtract(int first,int second){
        return first-second;
    }
    private int multiply(int first,int second){
        return first*second;
    }
    private double divide(int first,int second){
        return first/second;
    }
    private int computerLength(String name){
        return name.length();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       int first = request.getParameter("first")!=null?Integer.parseInt(request.getParameter("first")):0;
       int second=request.getParameter("second")!=null?Integer.parseInt(request.getParameter("second")):0;
       String name=request.getParameter("name");
       String action=request.getParameter("action");
       int result = 0;
       if(action.equals("Add")){
           result=add(first,second);
       }else if(action.equals("Subtract")){
           result=subtract(first,second);
       }else if(action.equals("Multiply")){
        result=multiply(first,second);
       }else if (action.equals("Divide")){
        result=(int)(divide(first,second));
       }else if (action.equals("ComputeLength")){
        result=computerLength(name);
       }
        if (action.equals("Add")|| action.equals("Subtract") || action.equals("Multiply") || action.equals("Divide")) {
        Cookie cFirstVal=new Cookie("first",String.valueOf(first));
        Cookie cSecondVal=new Cookie("second",String.valueOf(second));
        Cookie cResult=new Cookie("result",String.valueOf(result));
        cFirstVal.setMaxAge(8);
        cSecondVal.setMaxAge(8);
        cResult.setMaxAge(8);
        response.addCookie(cFirstVal);
        response.addCookie(cSecondVal);
        response.addCookie(cResult);
    }
        if (action.equals("ComputeLength")){
        Cookie cComputerLength=new Cookie("name",String.valueOf(name));
        Cookie cLength=new Cookie("length",String.valueOf(result));
        cComputerLength.setMaxAge(8);
        cLength.setMaxAge(8);
        response.addCookie(cComputerLength);
        response.addCookie(cLength);
    }
        response.sendRedirect("Lab3/cal.jsp");

}

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
