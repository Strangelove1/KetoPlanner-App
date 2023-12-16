<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1> Edit ingredient info</h1>
<form:form method="post" modelAttribute="ingredient">
    <table>
        <tr>
            <td><form:label path="name"> Update name </form:label></td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name"/></td>
        </tr>
        <tr>
            <td><form:label path="weight"> Update weight </form:label></td>
            <td><form:input path="weight"/></td>
            <td><form:errors path="weight"/></td>
        </tr>
        <tr>
            <td><form:label path="kcal"> Update kcal</form:label></td>
            <td><form:input path="kcal"/></td>
            <td><form:errors path="kcal"/></td>
        </tr>
        <tr>
            <td><form:label path="carbohydrates"> Update carbohydrates</form:label></td>
            <td><form:input path="carbohydrates"/></td>
            <td><form:errors path="carbohydrates"/></td>
        </tr>
        <tr>
            <td><form:label path="description"> Update description </form:label></td>
            <td><form:input path="description"/></td>
            <td><form:errors path="description"/></td>
        </tr>
    </table>
    <input type="submit">
</form:form>
</body>
</html>