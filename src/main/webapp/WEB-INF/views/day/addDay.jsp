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
    <title>Create Day</title>
    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
    <script>
        // Function to update total Kcal and Carbohydrates
        function updateTotals() {
            // Send an AJAX request to get the updated values from the server
            $.get("/days/calculateTotals", {mealIds: $("#meals").val()}, function (data) {
                // Update the view with the new values
                $("#totalKcal").text(data.totalKcal);
                $("#totalCarbohydrates").text(data.totalCarbohydrates);
            });
        }

        // Attach the updateTotals function to the change event of the Meals select
        $(document).ready(function () {
            $("#meals").change(updateTotals);
        });
    </script>
</head>
<body>

<h2>Create a New Day</h2>

<form:form method="post" modelAttribute="day">
    <table>
        <tr>
            <td>Week:</td>
            <td><form:select path="week.id">
                <form:option value="" label="-- Select Week --"/>
                <form:options items="${weeks}" itemValue="id" itemLabel="weekName"/>
            </form:select></td>
        </tr>
        <tr>
            <td>Day Name:</td>
            <td><form:select path="dayNames.id">
                <form:option value="" label="-- Select Day Name --"/>
                <form:options items="${dayNames}" itemValue="id" itemLabel="name"/>
            </form:select></td>
        </tr>
        <tr>
            <td>Created:</td>
            <td><form:input path="created" type="date"/>
                <form:errors path="created"/></td>
        </tr>
        <tr>
            <td>Meals:</td>
            <td><form:select path="meals" multiple="true" id="meals">
                <form:options items="${meals}" itemValue="id" itemLabel="name"/>
            </form:select></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Create Day"/>
            </td>
        </tr>
        <tr>
            <td>Total Kcal:</td>
            <td id="totalKcal">${day.kcal}</td>
        </tr>
        <tr>
            <td>Total Carbohydrates:</td>
            <td id="totalCarbohydrates">${day.carbohydrates}</td>
        </tr>
    </table>
</form:form>

</body>
</html>

