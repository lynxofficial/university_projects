<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Specialty information</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        form {
            text-align: center;
            border-collapse: collapse;
            margin: auto;
        }
    </style>
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-center">
    <h2>Specialty information</h2>
</div>
<br>
<%--@elvariable id="specialty" type="java"--%>
<form:form action="saveSpecialty" modelAttribute="specialty">
    <form:hidden path="specialtyId"/>
    Specialty code
    <form:input path="specialtyCode"/>
    <br><br>
    Specialty name
    <form:input path="specialtyName"/>
    <br><br>
    Quota
    <form:input path="quota"/>
    <br><br>
    <br>
    <input type="submit" class="w3-submit w3-green w3-round-large w3-margin" value="OK"/>
</form:form>
</body>
</html>