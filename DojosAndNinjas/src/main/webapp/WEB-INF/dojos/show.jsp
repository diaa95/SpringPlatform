<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/10/2021
  Time: 2:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>All Dojos</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body style="padding-top: 4.5rem;">
    <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="/">Dojos</a>
            <ul class="navbar-nav me-auto mb-2">
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/dojos/new">Add Dojo</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" aria-current="page" href="/ninjas/new">Add Ninja</a>
                </li>
            </ul>
        </div>
    </nav>
    <main class="container">
        <div class="bg-light p-5 rounded">
            <table class="table table-hover table-striped table-bordered table-dark">
                <thead>
                <tr>
                    <th scope="col">Dojo Id</th>
                    <th scope="col">Name</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${dojos}" var="dojo">
                    <tr>
                        <td><c:out value="${dojo.id}"/></td>
                        <td><a href="/dojos/${dojo.id}"><c:out value="${dojo.name}"/></a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </main>
</body>
</html>
