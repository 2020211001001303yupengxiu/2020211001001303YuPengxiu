<%--
  Created by IntelliJ IDEA.
  User: yupengxiu
  Date: 2022/4/5
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="textml;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Info </h1>
    <table>
    <tr>
        <td>ID:</td><td><%=request.getAttribute("id")%></td>
    </tr>
    <tr>
        <td>Username:</td><td><%=request.getAttribute("username")%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=request.getAttribute("password")%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=request.getAttribute("Email")%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=request.getAttribute("gender")%></td>
    </tr>
    <tr>
        <td>Birthdays:</td><td><%=request.getAttribute("birth")%></td>
    </tr>
    </table>
<%@include file="footer.jsp"%>

