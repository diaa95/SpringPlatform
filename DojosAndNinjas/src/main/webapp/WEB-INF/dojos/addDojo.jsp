<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/10/2021
  Time: 2:27 PM
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
                <a class="nav-link" aria-current="page" href="/ninjas/new">Add Ninja</a>
            </li>
        </ul>
    </div>
</nav>
<div class="col-8 offset-2">
    <div class="col-8 offset-2">
        <form:form action="/dojos/new" method="post" modelAttribute="dojo">
            <div class="row mb-3">
                <form:label path="name" class="col-sm-2 col-form-label">Name</form:label>
                <form:errors path="name" class="text-danger"/>
                <form:input path="name" class="form-control"/>
            </div>
            <input type="submit" value="Add Dojo" class="btn btn-dark"/>
        </form:form>
    </div>
</div>
</body>
</html>
