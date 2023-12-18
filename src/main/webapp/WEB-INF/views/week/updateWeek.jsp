<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 13.12.2023
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Create Week</title>
</head>
<body>

<h2>Update Week</h2>

<form:form method="post" modelAttribute="week">
    <table>
        <tr>
            <td>Week name:</td>
            <td><form:input path="weekName"/>
                <form:errors path="weekName"/></td>
        </tr>

        <tr>
            <td>Days:</td>
            <td><form:select path="days" multiple="true">
                <form:option value="" label="-- Select days --"/>
                <form:options items="${days}" itemValue="id" itemLabel="dayName"/>
            </form:select>
                <form:errors path="days"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Create Week"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
