<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 13.12.2023
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Week list</title>
</head>
<body>
<a href="/weeks/create"> Add week </a>
<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Created</td>
    </tr>
    <c:forEach items="${weeks}" var="week">
        <tr>
        <td>${week.id}</td>
        <td>${week.weekName}</td>
        <td>${week.created}</td>
            <td>
                <a href="<c:url value="/week/updateWeek/${week.id}"/>"> Edit </a>
                <a href="<c:url value="/week/deleteWeek/${week.id}"/>"> Delete </a>
            </td>
        </tr>
        <c:forEach items="${week.days}" var="day">
            <tr>
                <td>${day.dayNames}</td>
                <td>
                    <a href="<c:url value="/day/dayDetails/${day.id}"/>"> Day details </a>
                </td>
            </tr>
        </c:forEach>
    </c:forEach>
</table>
</body>
</html>
