<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
    <body style="padding-top: 4.5rem;">
        <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
            <div class="container-fluid">
                <h1>Welcome, <c:out value="${user.first_name}" /></h1>
                <ul class="navbar-nav me-auto mb-2">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/home">Home</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="/logout">Logout!</a>
                    </li>
                </ul>
            </div>
        </nav>
        <main class="container">
            <div class="bg-light p-5 rounded">
                <P>Here are some of the events in your state:</P>
                <table class="table table-hover table-striped table-bordered table-dark">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Date</th>
                        <th scope="col">Location</th>
                        <th scope="col">Host</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${inState}" var="state">
                        <tr>
                            <td><a href="/events/${state.id}"><c:out value="${state.name}"/></a></td>
                            <td><c:out value="${state.stringDate}"/></td>
                            <td><c:out value="${state.location}"/></td>
                            <td><c:out value="${state.host.first_name}"/></td>
                            <c:choose>
                                <c:when test="${state.host.id == user.id}">
                                    <td><a href="/events/${state.id}/edit">Edit</a> |
                                        <form style="display: inline" action="/destroy/${state.id}" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input style="background: none; border: none; padding: 0;color: #4883ff;" type="submit" value="Delete">
                                    </form></td>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${state.users.contains(user)}">
                                            <td>Joining | <a href="/cancel/${state.id}">Cancel</a></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><a href="/joinEvent/${state.id}">Join</a></td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="bg-light p-5 rounded">
                <P>Here are some of the events in other states:</P>
                <table class="table table-hover table-striped table-bordered table-dark">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Date</th>
                        <th scope="col">Location</th>
                        <th scope="col">State</th>
                        <th scope="col">Host</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${notInState}" var="state">
                        <tr>
                            <td><a href="/events/${state.id}"><c:out value="${state.name}"/></a></td>
                            <td><c:out value="${state.stringDate}"/></td>
                            <td><c:out value="${state.location}"/></td>
                            <td><c:out value="${state.state}"/></td>
                            <td><c:out value="${state.host.first_name}"/></td>
                            <c:choose>
                                <c:when test="${state.host.id == user.id}">
                                    <td><a href="/events/${state.id}/edit">Edit</a> |
                                        <form style="display: inline" action="/destroy/${state.id}" method="post">
                                        <input type="hidden" name="_method" value="delete">
                                        <input style="background: none; border: none; padding: 0;color: #4883ff;" type="submit" value="Delete">
                                    </form></td>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${state.users.contains(user)}">
                                            <td>Joining | <a href="/cancel/${state.id}">Cancel</a></td>
                                        </c:when>
                                        <c:otherwise>
                                            <td><a href="/joinEvent/${state.id}">Join</a></td>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <h2 class="text-dark">Create an Event</h2><br>
            <div class="row g-3 align-items-center col-auto text-dark">
                <form:form class="px-4 py-3" action="/addEvent" method="post" modelAttribute="event">
                    <div class="mb-3">
                        <form:label path="name" class="form-label">Name </form:label>
                        <form:errors path="name" class="row text-danger"/>
                        <form:input path="name" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <form:label path="date" class="form-label">Date </form:label>
                        <form:errors path="date" class="row text-danger"/>
                        <form:input type="date" class="form-control" path="date"/>
                    </div>
                    <div class="mb-3">
                        <form:label path="location" class="form-label">Location </form:label>
                        <form:errors path="location" class="row text-danger"/>
                        <form:input path="location" class="form-control"/>
                    </div>
                    <div class="mb-3">
                        <form:select path="state">
                            <c:forEach items="${states}" var="state">
                                <form:option value="${state}">${state}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <input type="submit" value="Submit" class="btn btn-dark"/>
                </form:form>
            </div>
        </main>
    </body>
</html>
