<%--
  Created by IntelliJ IDEA.
  User: yupengxiu
  Date: 2022/4/5
  Time: 18:32
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
<h2>Welcome to My Online Shop Home Page.</h2> <br>
<form method="get" target="_blank" action="search">
    <input type="text" name="text" size="30"/>
    <select name="search">
        <option value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="Search"/>
</form>
<%@include file="footer.jsp"%>
