<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/8/2021
  Time: 5:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Edit Language</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body class="col-8 offset-2">
    <h1>Edit Language</h1>
    <div>
        <form:form action="/languages/${language.id}" method="post" modelAttribute="language">
            <input type="hidden" name="_method" value="put">
            <div class="row mb-3">
                <form:label path="name" class="col-sm-2 col-form-label">Name</form:label>
                <form:errors path="name" class="text-danger"/>
                <form:input path="name" class="form-control"/>
            </div>
            <div class="row mb-3">
                <form:label path="creator" class="col-sm-2 col-form-label">Creator</form:label>
                <form:errors path="creator" class="text-danger"/>
                <form:input path="creator" class="form-control"/>
            </div>
            <div class="row mb-3">
                <form:label path="version" class="col-sm-2 col-form-label">Version</form:label>
                <form:errors path="version"/>
                <form:input path="version" class="form-control"/>
            </div>
            <input type="submit" value="Submit" class="btn btn-dark"/>
        </form:form>
    </div>
</body>
</html>
