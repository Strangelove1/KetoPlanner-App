<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 18.12.2023
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Login</title>
</head>
<body>

<h2>User Login</h2>

<form:form method="post" modelAttribute="loginForm">
    <table>
        <tr>
            <td>Email:</td>
            <td><form:input path="email" type="email"/>
                <form:errors path="email"/></td>
        </tr>

        <tr>
            <td>Password:</td>
            <td><form:input path="password" type="password"/>
                <form:errors path="password"/></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Login"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>