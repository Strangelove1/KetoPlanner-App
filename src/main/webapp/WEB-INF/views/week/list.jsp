<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: riain
  Date: 13.12.2023
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Week list</title>
</head>
<body>
<a href="/weeks/create"> Add week </a>
<a href="/"> Dashboard </a>

<table>
    <tr>
        <td>ID</td>
        <td>Name</td>
        <td>Created</td>
    </tr>
    <c:forEach items="${weeks}" var="week">
        <tr>
            <td>Week ID ${week.id}</td>
            <td><h3>${week.weekName}</h3> </td>
            <td>${week.created}</td>
            <td>
                <a href="<c:url value="/weeks/updateWeek/${week.id}"/>"> Edit </a>
                <a href="/weeks/deleteWeek/${week.id}"> Delete </a>
            </td>
        </tr>

        <c:forEach var="day" items="${weekDaysMap[week]}">
            <tr>
                <td>Day ID ${day.id}</td>
                <td>${day.dayNames.name}</td> <!-- Replace with the actual day name property -->
                <td>${day.created}</td>
                <td>
                    <a href="<c:url value="/day/dayDetails/${day.id}"/>"> Day details </a>
                </td>
            </tr>
        </c:forEach>
        <tr>
            <td>-----------------</td>
            <td>------------------------</td>
            <td>-----------------</td>
            <td>-----------------</td>
        </tr>

    </c:forEach>
</table>
</body>
</html>