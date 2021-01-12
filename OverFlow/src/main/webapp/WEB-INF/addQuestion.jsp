<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/12/2021
  Time: 8:13 PM
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
<body>
    <form:form action="/addQuestion" method="post" modelAttribute="question">
        <p>
            <form:label path="context">Question:</form:label>
            <form:errors path="context"/>
            <form:textarea path="context"/>
        </p>
        <form:form action="/addQuestion" method="post" modelAttribute="tag">
            <p>
                <form:label path="subject">Tag:</form:label>
                <form:errors path="subject"/>
                <form:input path="subject"/>
            </p>
            <input type="submit" value="Submit"/>
        </form:form>
    </form:form>
</body>
</html>
