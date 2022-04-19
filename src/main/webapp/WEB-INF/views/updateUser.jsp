<%--
  Created by IntelliJ IDEA.
  User: yupengxiu
  Date: 2022/3/6
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User u=(User) session.getAttribute("user");
%>
<form method="post"  action="updateUser" onsubmit="return check()">
    <input type="hidden" name="id" placeholder="id" value="<%=u.getId()%>" required>
    <p>username:<input type="text" name="username" placeholder="username" value="<%=u.getUsername()%>" required></p>
    <p>password:<input type="password" name="password" placeholder="password" value="<%=u.getPassword()%>" required id="password"></p>
    <p>email:<input type="email" name="Email" placeholder="Email" value="<%=u.getEmail()%>"></p>
    <p>Gender:<input  type="radio" name="sex" value="Male" <%="Male".equals(u.getGender())?"checked":""%> checked="checked">Male
        <input  type="radio" name="sex" placeholder="Female" <%="Female".equals(u.getGender())?"checked":""%>>Female</p>
    <p>BirthDate:<input type="date" name="birth" value="<%=u.getBirth()%>" required></p>
    <input name="submit" type="submit" value="Save Changes">
</form>
<%@include file="footer.jsp"%>
