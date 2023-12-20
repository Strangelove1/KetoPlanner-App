<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 13.12.2023
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/ingredient/create"/>"> add ingredient</a>
<a href="/"> Dashboard </a>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Description</td>
        <td>Kcal</td>
        <td>Carbohydrates</td>
        <td>Weight</td>
    </tr>
    <c:forEach items="${ingredients}" var="ingredient">
        <tr>
            <td>${ingredient.id}</td>
            <td>${ingredient.name}</td>
            <td>${ingredient.description}</td>
            <td>${ingredient.kcal}</td>
            <td>${ingredient.carbohydrates}</td>
            <td>${ingredient.weight}</td>
            <td>
                <a href="<c:url value="/ingredient/editIngredient/${ingredient.id}"/>"> Edit </a>
                <a href="<c:url value="/ingredient/deleteIngredient/${ingredient.id}"/>"> Delete </a>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
