<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/11/2021
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Add Product</title>
</head>
<body>
<h1>New Product</h1>
<form:form action="/products/new" method="post" modelAttribute="product">
    <p>
        <form:label path="name">Product's Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="description">Product's Description</form:label>
        <form:errors path="description"/>
        <form:textarea path="description"/>
    </p>
    <p>
        <form:label path="price">Product's Price</form:label>
        <form:errors path="price"/>
        <form:input type="number" path="price"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>