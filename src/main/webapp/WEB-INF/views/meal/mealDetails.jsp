<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 14.12.2023
  Time: 19:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="<c:url value="/meals/list"/>"> Back to the list </a>
<br>
Meal details:
<br>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Description</td>
        <td>Kcal</td>
        <td>Carbohydrates</td>
        <td>Weight</td>
    </tr>
    <c:forEach items="${ingredientList}" var="ingredient">
    <tr>
        <td>${ingredient.id}</td>
        <td>${ingredient.name}</td>
        <td>${ingredient.description}</td>
        <td>${ingredient.kcal}</td>
        <td>${ingredient.carbohydrates}</td>
        <td>${ingredient.weight}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
