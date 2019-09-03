<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/8/27
  Time: 0:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>Orders</title>
</head>
<body>
<table border="1" width="100%">
    <tr>
        <td>user_id</td>
        <td>Number</td>
        <td>Note</td>
        <td>UserName</td>
        <td>UserAddr</td>
    </tr>
    <c:forEach items="${orderListKey}" var="orders">
        <tr>
            <td>${orders.user_id}</td>
            <td>${orders.number}</td>
            <td>${orders.note}</td>
            <td>${orders.userName}</td>
            <td>${orders.userAddr}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
