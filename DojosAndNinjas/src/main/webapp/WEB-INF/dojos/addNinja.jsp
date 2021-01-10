<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/10/2021
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Add Dojo</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding-top: 4.5rem;">
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Dojos</a>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/dojos/new">Add Dojo</a>
            </li>
        </ul>
    </div>
</nav>
<div class="col-8 offset-2">
    <div class="col-8 offset-2">
        <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
            <div class="row mb-3 form-select">
                <form:label path="dojo">Dojo</form:label>
                <form:errors path="dojo"/>
                <form:select path="dojo">
                    <c:forEach items="${dojos}" var="dojo">
                        <form:option value="${dojo.id}">${dojo.name}</form:option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="row mb-3">
                <form:label path="firstName">First Name</form:label>
                <form:errors path="firstName"/>
                <form:input path="firstName"/>
            </div>
            <div class="row mb-3">
                <form:label path="lastName">Last Name</form:label>
                <form:errors path="lastName"/>
                <form:input path="lastName"/>
            </div>
            <div class="row mb-3">
                <form:label path="age">Age</form:label>
                <form:errors path="age"/>
                <form:input path="age"/>
            </div>
            <input type="submit" value="Submit" class="btn btn-dark"/>
        </form:form>
    </div>
</div>
</body>
</html>