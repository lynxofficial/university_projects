<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Applicants</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        table {
            width: 1530px;
            margin: auto;
            border-collapse: collapse;
        }

        td {
            text-align: center;
            border: 1px solid green;
        }
    </style>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h2>List of applicants</h2>
</div>
<br>
<table>
    <tr>
        <th>
            <div class="w3-container w3-green">Last name</div>
        </th>
        <th>
            <div class="w3-container w3-green">First name</div>
        </th>
        <th>
            <div class="w3-container w3-green">Middle name</div>
        </th>
        <th>
            <div class="w3-container w3-green">Phone</div>
        </th>
        <th>
            <div class="w3-container w3-green">Email</div>
        </th>
        <th>
            <div class="w3-container w3-green">Operations</div>
        </th>
    </tr>
    <jsp:useBean id="applicants" scope="request" type="java.util.List"/>
    <c:forEach var="specialty" items="${applicants}">
        <c:url var="updateButton" value="/mvc/updateApplicant">
            <c:param name="applicantId" value="${specialty.applicantId}"/>
        </c:url>
        <c:url var="deleteButton" value="/mvc/deleteApplicant">
            <c:param name="applicantId" value="${specialty.applicantId}"/>
        </c:url>
        <c:url var="addDirectionButton" value="/mvc/addApplicantDirection">
            <c:param name="applicantId" value="${specialty.applicantId}"/>
        </c:url>
        <tr>
            <td>${specialty.lastName}</td>
            <td>${specialty.firstName}</td>
            <td>${specialty.middleName}</td>
            <td>${specialty.phone}</td>
            <td>${specialty.email}</td>
            <td>
                <input type="button" class="w3-btn w3-green w3-round-large w3-margin" value="Add direction"
                       onclick="window.location.href='${addDirectionButton}'"/>
                <input type="button" class="w3-btn w3-green w3-round-large w3-margin" value="Update"
                       onclick="window.location.href='${updateButton}'"/>
                <input type="button" class="w3-btn w3-green w3-round-large w3-margin" value="Delete"
                       onclick="window.location.href='${deleteButton}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
<div style="text-align: center;">
    <input type="button" class="w3-btn w3-green w3-round-large" value="Add"
           onclick="window.location.href='addNewApplicant'"/>
</div>
<br>
<div style="text-align: center;">
    <input type="button" class="w3-btn w3-green w3-round-large" value="To specialties"
           onclick="window.location.href='specialties'"/>
</div>
</body>
</html>