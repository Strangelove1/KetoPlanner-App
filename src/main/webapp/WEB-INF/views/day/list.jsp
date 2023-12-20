<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/days/create"> Add day </a>
<a href="/"> Dashboard </a>
<table>
    <tr>
        <td>ID</td>
        <td>Day</td>
        <td>Kcal</td>
        <td>Carbohydrates</td>
        <td>Is keto friendly?</td>
        <td>Created</td>
    </tr>
    <c:forEach items="${days}" var="day">
        <tr>
            <td>${day.id}</td>
            <td>${day.dayNames.name}</td>
            <td>${day.kcal}</td>
            <td>${day.carbohydrates}</td>
            <td>${day.ketoFriendly}</td>
            <td>${day.created}</td>

            <td>
                <a href="<c:url value="/days/updateDay/${day.id}"/>"> Edit </a>
                <a href="<c:url value="/days/deleteDay/${day.id}"/>"> Delete </a>
                <a href="<c:url value="/days/dayDetails/${day.id}"/>"> Details </a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>