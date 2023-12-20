<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 14.12.2023
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>

</head>
<body>

<h2>Add meal</h2>

<form:form method="post" modelAttribute="meal">
    <table id="ingredientTable">
        <tr>
            <td><form:label path="name"> Name </form:label></td>
            <td><form:input path="name"/>
                <form:errors path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="description"> Description </form:label></td>
            <td><form:input path="description"/>
                <form:errors path="description"/></td>
        </tr>

        <tr>
            <td>Choose ingredients</td>
            <td><form:select path="ingredientsList" multiple="true">
                <form:option value="" label="-- Select ingredients --"/>
                <form:options items="${ingredients}" itemValue="id" itemLabel="name"/>
                </form:select>
                <form:errors path="ingredientsList"/></td>
        </tr>
    </table>
    <input type="submit" value="submit">
</form:form>

</body>
</html>
