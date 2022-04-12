<%@ page import="static javax.swing.text.html.CSS.getAttribute" %><%--
  Created by IntelliJ IDEA.
  User: yupengxiu
  Date: 2022/3/29
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if (request.getAttribute("message")!=null){
        out.print(request.getAttribute("message"));
    }
%>

<form method="post"  action="/YuPengxiu2020211001001303/login" onsubmit="return check()">
    <p>username:<input type="text" name="username" placeholder="username" required></p>
    <p>password:<input type="password" name="password" placeholder="password" required id="password"></p>
    <input name="login" type="submit" value="login">
</form>
<%@include file="footer.jsp"%>
