<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/9/2021
  Time: 1:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Show</title>
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
        <h1>Title: <c:out value="${song.title}"/></h1>
        <p>Artist: <c:out value="${song.artist}"/></p>
        <p>Rating(1-10): <c:out value="${song.rating}"/></p>
        <br>
        <form action="/songs/${song.id}" method="post">
            <input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete" class="btn btn-dark">
        </form>
    </div>
</body>
</html>
