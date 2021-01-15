<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
</head>
<body>
<h1>Register!</h1>

<p><form:errors path="user.*"/></p>

<form:form method="POST" action="/registration" modelAttribute="user">
    <p>
        <form:label path="email">Email:</form:label>
        <form:input type="email" path="email"/>
    </p>
    <p>
        <form:label path="password">Password:</form:label>
        <form:password path="password"/>
    </p>
    <p>
        <form:label path="passwordConfirmation">Password Confirmation:</form:label>
        <form:password path="passwordConfirmation"/>
    </p>
    <input type="submit" value="Register!"/>
</form:form>

<p><form:errors path="logIn.*"/></p>
<form:form method="POST" action="/logIn" modelAttribute="logIn">
    <p>
        <form:label path="registeredEmail">Email:</form:label>
        <form:input type="email" path="registeredEmail"/>
    </p>
    <p>
        <form:label path="registeredPassword">Password:</form:label>
        <form:password path="registeredPassword"/>
    </p>
    <input type="submit" value="LogIn!"/>
</form:form>
<%--<form action="/logIn" method="post">--%>
<%--    <label>Email: <input type="email" name="email"></label>--%>
<%--    <label>Password:<input type="password" name="password"></label>--%>
<%--    <button type="submit">Log In</button>--%>
<%--</form>--%>

</body>
</html>
