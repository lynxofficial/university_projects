<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Applicant information</title>
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
    <h2>Applicant information</h2>
</div>
<br>
<%--@elvariable id="applicant" type="java"--%>
<form:form action="saveApplicant" modelAttribute="applicant">
    <form:hidden path="applicantId"/>
    Last name
    <form:input path="lastName"/>
    <br><br>
    First name
    <form:input path="firstName"/>
    <br><br>
    Middle name
    <form:input path="middleName"/>
    <br><br>
    Phone
    <form:input path="phone"/>
    <br><br>
    Email
    <form:input path="email"/>
    <br>
    <input type="submit" class="w3-submit w3-green w3-round-large w3-margin" value="OK"/>
</form:form>
</body>
</html>