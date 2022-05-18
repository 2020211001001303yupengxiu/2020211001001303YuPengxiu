<%--
  Created by IntelliJ IDEA.
  User: yupengxiu
  Date: 2022/5/18
  Time: 8:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab1</title>
</head>
<body>
<table>
    <%
        String ID=request.getParameter("ID");
        String name=request.getParameter("name");
        String Class=request.getParameter("Class");
        String submit=request.getParameter("submit");
       /* out.println("ID:"+ID+"<br/>");
        out.println("name:"+name+"<br/>");
        out.println("Class:"+Class+"<br/>");
        out.println("submit:"+submit);*/
    %>
    name: ${param.name}<br/>
    ID: ${param.ID}<br/>
    Class: ${param.Class}<br/>
    submit: ${param.submit}
</table>
</body>
</html>
