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
<%
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeVal="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cUsername")){
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                rememberMeVal=c.getValue();
            }
        }
    }
%>
<form method="post"  action="/YuPengxiu2020211001001303/login" onsubmit="return check()">
    <p>username:<input type="text" name="username" placeholder="username" value="<%=username%>" required></p>
    <p>password:<input type="password" name="password" placeholder="password" required id="password" value="<%=password%>"></p>
    <input type="checkbox" value="1" name="rememberMe" <%=rememberMeVal.equals("1") ?"checked":""%> />RememberMe<br/>
    <input name="login" type="submit" value="login">
</form>
<%@include file="footer.jsp"%>
