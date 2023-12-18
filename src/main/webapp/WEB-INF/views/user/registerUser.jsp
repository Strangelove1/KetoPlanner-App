<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 12.12.2023
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>

<h2>User Registration</h2>

<form:form method="post" modelAttribute="user">
    <table>
        <tr>
            <td>Name:</td>
            <td><form:input path="name"/>
                <form:errors path="name"/></td>
        </tr>

        <tr>
            <td>Last Name:</td>
            <td><form:input path="lastName"/>
                <form:errors path="lastName"/></td>
        </tr>

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
                <input type="submit" value="Register User"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>