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
    <title>Update Week</title>
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
            <td colspan="2">
                <input type="submit" value="Update Week"/>
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
