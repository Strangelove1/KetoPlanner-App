<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 17.12.2023
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Day details:
<br>
<table>
    <tr>
        <td>Meal ID</td>
        <td>Name</td>
        <td>Description</td>
        <td>Kcal</td>
        <td>Carbs</td>
    </tr>
    <c:forEach items="${mealList}" var="meal">
        <tr>
            <td>${meal.id}</td>
            <td>${meal.name}</td>
            <td>${meal.description}</td>
            <td>${meal.kcal}</td>
            <td>${meal.carbohydrates}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
