<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Specialties</title>
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
    <h2>List of specialties</h2>
</div>
<br>
<table>
    <tr>
        <th>
            <div class="w3-container w3-green">Specialty code</div>
        </th>
        <th>
            <div class="w3-container w3-green">Specialty name</div>
        </th>
        <th>
            <div class="w3-container w3-green">Operations</div>
        </th>
    </tr>
    <jsp:useBean id="applicant" scope="request" type="com.spring.mvc.admission_committee.entity.Applicant"/>
    <jsp:useBean id="specialties" scope="request" type="java.util.List"/>
    <c:forEach var="specialty" items="${specialties}">
        <c:url var="addSelectedSpecialtyToApplicant" value="/mvc/addSelectedSpecialtyToApplicant">
            <c:param name="specialtyId" value="${specialty.specialtyId}"/>
            <c:param name="applicantId" value="${applicant.applicantId}"/>
        </c:url>
        <tr>
            <td>${specialty.specialtyCode}</td>
            <td>${specialty.specialtyName}</td>
            <td>
                <input type="button" class="w3-btn w3-green w3-round-large w3-margin" value="Change this specialty"
                       onclick="window.location.href='${addSelectedSpecialtyToApplicant}'"/>
            </td>
        </tr>
    </c:forEach>
</table>
<br>
</body>
</html>