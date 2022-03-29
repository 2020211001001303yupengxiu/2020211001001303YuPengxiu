<%--
  Created by IntelliJ IDEA.
  User: yupengxiu
  Date: 2022/3/6
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<form method="post"  action="/YuPengxiu2020211001001303/register" onsubmit="return check()">
    <p>ID:<input type="text" name="id" placeholder="id" required></p>
    <p>username:<input type="text" name="username" placeholder="username" required></p>
    <p>password:<input type="password" name="password" placeholder="password" required id="password"></p>
    <p>email:<input type="email" name="Email" placeholder="Email"></p>
    <p>Gender:<input  type="radio" name="sex" value="Male" checked="checked">Male  <input  type="radio" name="sex" placeholder="Female">Female</p>
    <p>BirthDate:<input type="date" name="birth" required></p>
    <input name="submit" type="submit" value="submit">
    <input name="reset" type="reset" value="reset">
</form>
<%@include file="footer.jsp"%>
