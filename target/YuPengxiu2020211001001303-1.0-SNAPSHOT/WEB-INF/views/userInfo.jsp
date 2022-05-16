<%@ page import="com.model.User" %><%--
  Created by IntelliJ IDEA.
  User: yupengxiu
  Date: 2022/4/5
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="textml;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1> User Info </h1>
<%
    User u=(User)session.getAttribute("user");
%>
    <table>
    <tr>
        <td>ID:</td><td><%=u.getId()%></td>
    </tr>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td><td><%=u.getPassword()%></td>
    </tr>
    <tr>
        <td>Email:</td><td><%=u.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender:</td><td><%=u.getGender()%></td>
    </tr>
    <tr>
        <td>Birthdays:</td><td><%=u.getBirth()%></td>
    </tr>
        <tr>
            <a href="updateUser">UpdateUser</a>
        </tr>
    </table>
<%@include file="footer.jsp"%>

