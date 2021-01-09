<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/9/2021
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Artist</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding-top: 4.5rem;">
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="/">Lookify</a>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" aria-current="page" href="/dashboard">Dashboard</a>
            </li>
        </ul>
        <form class="d-flex" action="/search" method="post">
            <input  class="form-control me-2" type="search" placeholder="Search" name="artist">
            <button class="btn btn-outline-primary" type="submit">Search</button>
        </form>
    </div>
</nav>
<main class="container">
    <div class="bg-light p-5 rounded">
        <h2>Songs by artist: ${artist}</h2>
        <table class="table table-hover table-striped table-bordered table-dark">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Rating</th>
                <th scope="col">Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${songs}" var="song">
                <tr>
                    <td><a href="/songs/${song.id}"><c:out value="${song.title}"/></a></td>
                    <td><c:out value="${song.rating}"/></td>
                    <td>
                        <form style="display: inline" action="/songs/${song.id}" method="post">
                            <input type="hidden" name="_method" value="delete">
                            <input style="background: none; border: none; padding: 0;color: #4883ff;" type="submit" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
</body>
</html>
