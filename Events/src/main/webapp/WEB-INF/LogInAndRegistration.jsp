<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Page</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script>
        $(document).ready(function (){
            $('#password').on('keyup', function () {
                if($('#password').val().toLowerCase() == $('#password').val() ||
                    $('#password').val().length < 8 ||
                    /^[a-zA-Z0-9]*$/.test($('#password').val()) == true){
                    $('#message').html('Weak').css('color', 'red');
                }else
                    $('#message').html('Strong').css('color', 'green');
            });
            $('#confirm_password').on('keyup', function () {
                if ($('#password').val() == $('#confirm_password').val()) {
                    $('#message1').html('Matching').css('color', 'green');
                } else
                    $('#message1').html('Not Matching').css('color', 'red');
            });
        })
    </script>
</head>
<body style="display: flex; align-items: start; justify-content: space-evenly">
<h1 class="text-dark">Log In</h1>
<div class="row g-3 align-items-center text-dark">

    <form:form class="px-4 py-3" method="POST" action="/logIn" modelAttribute="logIn">
        <div class="mb-3">
            <form:label path="registeredEmail" class="form-label">Email:</form:label>
            <form:errors path="registeredEmail" class="row text-danger"/>
            <form:input type="email" path="registeredEmail" class="form-control" required="required"/>
        </div>
        <div class="mb-3">
            <form:label path="registeredPassword" class="form-label">Password:</form:label>
            <form:errors path="registeredPassword" class="row text-danger"/>
            <form:password path="registeredPassword" class="form-control" required="required" minlength="8"/>
        </div>
        <input type="submit" value="LogIn!" class="btn btn-success"/>
    </form:form>
</div>
<h1 class="text-dark">Register</h1>
<div class="row g-3 align-items-center col-auto text-dark">
    <form:form class="px-4 py-3" method="POST" action="/registration" modelAttribute="user">
        <div class="mb-3">
            <form:label path="first_name" class="form-label">First Name:</form:label>
            <form:errors path="first_name" class="row text-danger"/>
            <form:input  path="first_name" class="form-control" required="required"/>
        </div>
        <div class="mb-3">
            <form:label path="last_name" class="form-label">Last Name:</form:label>
            <form:errors path="last_name" class="row text-danger"/>
            <form:input  path="last_name" class="form-control" required="required"/>
        </div>
        <div class="mb-3">
            <form:label path="email" class="form-label">Email:</form:label>
            <form:errors path="email" class="row text-danger"/>
            <form:input type="email" path="email" class="form-control" required="required"/>
        </div>
        <div class="mb-3">
            <form:label path="location" class="form-label">Location:</form:label>
            <form:errors path="location" class="row text-danger"/>
            <form:input  path="location" class="form-control" required="required"/>
        </div>
        <div class="mb-3">
            <form:select path="state">
            <c:forEach items="${states}" var="state">
                <form:option value="${state}">${state}</form:option>
            </c:forEach>
            </form:select>
        </div>
        <div class="mb-3">
            <form:label path="password" class="form-label">Password:</form:label>
            <p id="message"></p>
            <form:errors path="password" class="row text-danger"/>
            <form:password path="password" class="form-control" required="required" minlength="8"/>
        </div>
        <div class="mb-3">
            <form:label path="passwordConfirmation" class="form-label">Password Confirmation:</form:label>
            <p id="message1"></p>
            <form:errors path="passwordConfirmation" id="password" class="row text-danger"/>
            <form:password path="passwordConfirmation" id="confirm_password" class="form-control" required="required" minlength="8"/>
        </div>
        <input type="submit" value="Register!" class="btn btn-info"/>
    </form:form>
</div>
</body>
</html>