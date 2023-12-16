<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 13.12.2023
  Time: 14:39
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!-- Assuming `meals` is a list/array of meal objects placed in the request or session scope by a servlet/controller -->
<c:set var="totalKcal" value="0"/>
<c:set var="totalCarbs" value="0"/>
<c:set var="carbsExceed" value="false"/>

<c:forEach var="meal" items="${meals}">
    <label>Name:</label>
    <input type="text" name="name" value="${meal.name}">
    <label>Carbohydrates:</label>
    <input type="number" name="carbohydrates" value="${meal.carbs}">
    <c:set var="totalCarbs" value="${totalCarbs + meal.carbs}"/>
    <label>Kcal:</label>
    <input type="number" name="kcal" value="${meal.kcal}">
    <c:set var="totalKcal" value="${totalKcal + meal.kcal}"/>
</c:forEach>

<c:if test="${totalCarbs > someConsoleAmount}">
    <c:set var="carbsExceed" value="true"/>
</c:if>

<p>Total kcal: ${totalKcal}</p>
<p>Total carbohydrates: ${totalCarbs}</p>
<p>Does it exceed the limit: ${carbsExceed}</p>

</body>
</html>