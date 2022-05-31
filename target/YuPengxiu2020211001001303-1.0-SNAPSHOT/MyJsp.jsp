<%--
  Created by IntelliJ IDEA.
  User: yupengxiu
  Date: 2022/5/18
  Time: 8:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lab1</title>
</head>
<body>
<h1>i am MyJsp.jsp</h1>
<form method="post"  action="MyDearJsp.jsp">
    <%--    <p>ID:<input type="text" name="id" placeholder="id" required></p>--%>
    <p>name:<input type="text" name="name" placeholder="name" required></p>
    <p>class:<input type="text" name="Class" placeholder="Class" required></p>
    <p>ID:<input type="text" name="ID" placeholder="ID"></p>
    <input name="submit" type="submit" value="Send data to server">
</form>
</body>
</html>
