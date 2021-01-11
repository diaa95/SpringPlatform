<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/11/2021
  Time: 8:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Product</title>
</head>
<body>
<h1>${product.name}</h1>
<ul>
    <c:forEach items="${product.categories}" var="category">
        <li>${category.name}</li>
    </c:forEach>
</ul>
<form action="/products/${product.id}" method="post">
    <select name="category">
        <c:forEach items="${categories}" var="category">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Add</button>
</form>
</body>
</html>
