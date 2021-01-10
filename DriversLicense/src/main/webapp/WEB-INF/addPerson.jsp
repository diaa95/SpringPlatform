<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/10/2021
  Time: 6:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Add Person</title>
</head>
<body>
<h1>New Person</h1>
<form:form action="/persons/new" method="post" modelAttribute="person">
    <p>
        <form:label path="firstname">First Name</form:label>
        <form:errors path="firstname"/>
        <form:input path="firstname"/>
    </p>
    <p>
        <form:label path="lastname">Last Name</form:label>
        <form:errors path="lastname"/>
        <form:input path="lastname"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>
