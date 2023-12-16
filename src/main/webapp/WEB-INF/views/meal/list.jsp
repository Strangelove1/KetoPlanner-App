<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 14.12.2023
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/meals/create"> Add Meal </a>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Description</td>
        <td>Kcal</td>
        <td>Carbohydrates</td>
    </tr>
    <c:forEach items="${meals}" var="meal">
        <tr>
            <td>${meal.id}</td>
            <td>${meal.name}</td>
            <td>${meal.description}</td>
            <td>${meal.kcal}</td>
            <td>${meal.carbohydrates}</td>
            <td>
                <a href="<c:url value="/meal/editMeal/${meal.id}"/>"> Edit </a>
                <a href="<c:url value="/meal/deleteMeal/${meal.id}"/>"> Delete </a>
                <a href="<c:url value="/meal/mealDetails/${meal.id}"/>"> Details </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
