<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<!-- Assuming `meals` is a list/array of meal objects placed in the request or session scope by a servlet/controller -->
<c:forEach var="meal" items="${meals}">
    <input type="text" value="${meal.name}">
    <input type="number" value="${meal.carbs}">
    <input type="number" value="${meal.kcal}">
</c:forEach>
