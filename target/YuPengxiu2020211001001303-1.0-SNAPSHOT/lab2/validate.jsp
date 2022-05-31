<%@ page import="com.Lab2.login" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="login" class="com.Lab2.login" scope="request"></jsp:useBean>
    <%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<jsp:setProperty name="login" property="username" value="admin"></jsp:setProperty>
<%
   //todo 3: use if check username is admin and ppassword is admin

    if(request.getParameter("username").equals("admin") && request.getParameter("password").equals("admin")){
        request.getRequestDispatcher("/lab2/welcome.jsp").forward(request,response);
    }  else{out.println("Username or Password Error");
%>
    <%--todo 4: use jsp:forward to welcome.jsp page--%>

    <%--todo 5: else part{ --%>

<%
// todo 6: print username or password error message

%>
    <%--todo 7: use jsp:include login.jsp page --%>
<jsp:include page="login.jsp"></jsp:include>
    <%--todo 8: close else --%>
<%
    }
%>
</body>
</html>