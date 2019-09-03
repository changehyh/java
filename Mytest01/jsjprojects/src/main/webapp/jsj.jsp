<%--
  Created by IntelliJ IDEA.
  User: asus
  Date: 2019/8/26
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<html>
<head>
    <title>User</title>
</head>
<body>
<table border="1" width="100%">
    <tr>
        <td>userName</td>
        <td>userAddr</td>
    </tr>
    <c:forEach items="${userListKey}" var="user">
        <tr>
            <td>${user.userName}</td>
            <td>${user.userAddr}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
