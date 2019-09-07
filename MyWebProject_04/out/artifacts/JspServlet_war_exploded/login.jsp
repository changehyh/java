<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/8/2
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
    <form action="loginServlet" method="post">
    username:<input type="text" name="username"><br>
    password:<input type="password" name="password"><br>
        <input type="submit" value="Submit">
        <input type="reset" value="Reset">
    </form>
</body>
</html>
