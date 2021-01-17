<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Event</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="row d-flex">
<div class="col-6">
    <h1>${event.name}</h1>
    <p>Host: ${event.host.first_name} ${event.host.last_name}</p>
    <p>Date: ${event.stringDate}</p>
    <p>Location: ${event.location}</p>
    <p>People who are attending this event: ${event.users.size()}</p>
    <div class="bg-light p-5 rounded">
        <table class="table table-hover table-striped table-bordered table-dark">
            <thead>
            <tr>
                <th scope="col">Name</th>
                <th scope="col">Location</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${event.users}" var="user">
                <tr>
                    <td><c:out value="${user.first_name} ${user.last_name}"/></td>
                    <td><c:out value="${user.location}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<div class="col-auto">
    <div>
        <h1>Message Wall</h1>
        <div class="col-12" style="max-height: 350px;width: 100% ;overflow-y: scroll; border:1px black solid;">
            <ul>
                <c:forEach items="${messages}" var="message">
                    <li><c:out value="${message.user.first_name}"/> says: <c:out value="${message.context}"/></li><br><br>
                    <p>**************************************</p><br><br>
                </c:forEach>
            </ul>
        </div>
    </div>
    <p class="text-dark">Add a Comment</p>
    <div class="row g-3 align-items-center col-auto text-dark">
        <form:form class="px-4 py-3" method="POST" action="/addMessage/${user.id}/${event.id}" modelAttribute="message">
            <div class="mb-3">
                <form:errors path="context" class="row text-danger"/>
                <form:textarea  path="context" class="form-control" required="required"/>
            </div>
            <input type="submit" value="Register!" class="btn btn-info"/>
        </form:form>
    </div>
</div>
</body>
</html>
