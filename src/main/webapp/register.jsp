<%--
  Created by IntelliJ IDEA.
  User: yupengxiu
  Date: 2022/3/6
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
    <style>
        input{
            height: 30px;
            margin-bottom: 5px;
        }
        </style>
    <script>
        function check() {
            var password= document.getElementById('password')
            if (password.value.length <8) {
                password.value="";
                password.placeholder="must be at least 8 characters long";
                return false;
            }
            else {
                return  true;
            }
        }
    </script>
</head>
<body>
<form method="post"  action="/YuPengxiu2020211001001303/register" onsubmit="return check()">
    <p><input type="text" name="id" placeholder="id" required></p>
    <p><input type="text" name="username" placeholder="username" required></p>
    <p><input type="password" name="password" placeholder="password" required id="password"></p>
    <p><input type="email" name="Email" placeholder="Email"></p>
    <p>Gender<input  type="radio" name="sex" value="Male" checked="checked">Male  <input  type="radio" name="sex" placeholder="Female">Female</p>
    <p><input type="date" name="birth" required></p>
    <input name="submit" type="submit" value="submit">
    <input name="reset" type="reset" value="reset">
</form>
</body>
</html>
