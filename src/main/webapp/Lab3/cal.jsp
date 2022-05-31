<%--
  Created by IntelliJ IDEA.
  User: yupengxiu
  Date: 2022/5/31
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    String first="";
    String second="";
    String name="";
    String length="";
    String result="";
    if (cookies!=null){
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("first")){
                first=cookie.getValue();
            }
            if (cookie.getName().equals("second")){
                second=cookie.getValue();
            }
            if (cookie.getName().equals("name")){
                name=cookie.getValue();
            }
            if (cookie.getName().equals("length")){
                length=cookie.getValue();
            }
            if (cookie.getName().equals("result")){
                result=cookie.getValue();
            }
        }
    }
    //update 5 user basepath
%>

<form action="<%=request.getContextPath()+"/CalServlet"%>" method="post">
    First Val : <input type="number" name="first" value="<%=first%>">
    Enter a Name: <input type="text" name="name" value="<%=name%>"><br>
    Second Val: <input type="number" name="second" value="<%=second%>">
    Length: <input type="number" name="length" value="<%=length%>" readonly><br>
    Result:<input type="text" name="result" value="<%=result%>" readonly><br>
    <button type="hidden" name="action" value="Add">Add</button>
    <button type="hidden" name="action" value="Subtract">Subtract</button>
    <button type="hidden" name="action" value="Multiply">Multiply</button>
    <button type="hidden" name="action" value="Divide">Divide</button>
    <button type="hidden" name="action" value="ComputeLength">Compute Length</button>
    <input type="reset" name="Reset" value="Reset"/>
</form>
</body>
</html>
