<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/9/2021
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Add song</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding-top: 4.5rem;">
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Lookify</a>
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link text-primary" aria-current="page" href="/dashboard">Dashboard</a>
                </li>
            </ul>
        </div>
    </nav>
    <div class="col-8 offset-2">
        <div class="col-8 offset-2">
            <form:form action="/songs" method="post" modelAttribute="song">
                <div class="row mb-3">
                    <form:label path="title" class="col-sm-2 col-form-label">Title</form:label>
                    <form:errors path="title" class="text-danger"/>
                    <form:input path="title" class="form-control"/>
                </div>
                <div class="row mb-3">
                    <form:label path="artist" class="col-sm-2 col-form-label">Artist</form:label>
                    <form:errors path="artist" class="text-danger"/>
                    <form:input path="artist" class="form-control"/>
                </div>
                <div class="row mb-3">
                    <form:label path="rating" class="col-sm-2 col-form-label">Rating</form:label>
                    <form:errors path="rating" class="text-danger"/>
                    <form:input path="rating" class="form-control"/>
                </div>
                <input type="submit" value="Add Song" class="btn btn-dark"/>
            </form:form>
        </div>
    </div>
</body>
</html>
