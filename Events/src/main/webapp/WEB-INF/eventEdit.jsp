<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit Event</title>
</head>
<body>
    <h1><c:out value="${event.name}"/></h1>
    <p><form:errors path="event.*"/></p>
    <form:form method="POST" action="/events/${event.id}/edit" modelAttribute="event">
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
        <form:input path="host" type="hidden" value="${event.host.id}"/>
        <input type="submit" value="Edit"/>
    </form:form>
</body>
</html>
