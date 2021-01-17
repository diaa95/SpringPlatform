<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 1/16/2021
  Time: 3:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Events</title>
</head>
<body>
    <header>
        <h1><c:out value="${loggedUser.firstName}"/></h1>
        <a href="/logout">Logout</a>
    </header>
    <main>
        <div>
            <h2>Here are some of the events in your state:</h2>
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>Host</th>
                    <th>Action / Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${inStateEvents}" var="event">
                    <tr>
                        <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
                        <td><c:out value="${event.date}"/></td>
                        <td><c:out value="${event.location}"/></td>
                        <td><c:out value="${event.userPlanner.firstName}"/></td>

                        <c:choose>
                            <c:when test="${event.userPlanner.id == loggedUser.id}">
                                <td><a href="/events/${event.id}/edit">Edit</a> | <a href="/destroy/${event.id}">Delete</a></td>
                            </c:when>
                            <c:otherwise>
                                <c:if test="${event.usersAttendingEvents.contains(loggedUser)}">
                                    <td>Joining | <a href="/cancel/${event.id}">Cancel</a></td>
                                </c:if>
                                <td><a href="/joinEvent/${event.id}">Join</a></td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <h2>Here are some of the events in your state:</h2>
            <table>
                <thead>
                <tr>
                    <th>Name</th>
                    <th>Date</th>
                    <th>Location</th>
                    <th>State</th>
                    <th>Host</th>
                    <th>Action / Status</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${outStateEvents}" var="event">
                    <tr>
                        <td><a href="/events/${event.id}"><c:out value="${event.name}"/></a></td>
                        <td><c:out value="${event.date}"/></td>
                        <td><c:out value="${event.location}"/></td>
                        <td><c:out value="${event.state}"/></td>
                        <td><c:out value="${event.userPlanner.firstName}"/></td>
                        <c:choose>
                            <c:when test="${event.userPlanner.id == loggedUser.id}">
                                <td><a href="/events/${event.id}/edit">Edit</a> | <a href="/destroy/${event.id}">Delete</a></td>
                            </c:when>
                            <c:otherwise>
                                <c:choose>
                                    <c:when test="${event.usersAttendingEvents.contains(loggedUser)}">
                                        <td>Joining | <a href="/cancel/${event.id}">Cancel</a></td>
                                    </c:when>
                                    <c:otherwise>
                                        <td><a href="/joinEvent/${event.id}">Join</a></td>
                                    </c:otherwise>
                                </c:choose>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div>
            <h2>Create an Event</h2>
            <p><form:errors path="event.*"/></p>
            <form:form method="POST" action="/createEvent" modelAttribute="event">
                <p>
                <form:label path="name">Name:</form:label>
                <form:input path="name"/>
                </p>
                <p>
                <form:label path="date">Date:</form:label>
                <form:input type="date" path="date"/>
                </p>
                <span>
                <form:label path="location">Location:</form:label>
                <form:input path="location"/>
                </span>
                <span>
                    <form:select path="state">
                        <c:forEach items="${states}" var="state">
                            <form:option value="${state}" label= "${state}"/>
                        </c:forEach>
                    </form:select>
                </span>
                <form:input path="userPlanner" type="hidden" value="${loggedUser.id}"/>
                <input type="submit" value="Create an Event!"/>
            </form:form>
        </div>
    </main>
</body>
</html>
