<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/11/2021
  Time: 4:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Category</title>
</head>
<body>
<h1>${category.name}</h1>
<ul>
    <c:forEach items="${category.products}" var="product">
        <li>${product.name}</li>
    </c:forEach>
</ul>
    <form action="/categories/${category.id}" method="post">
            <select name="product">
            <c:forEach items="${products}" var="uproduct">
                <option value="${uproduct.id}">${uproduct.name}</option>
            </c:forEach>
            </select>
        <button type="submit">Add</button>
    </form>
</body>
</html>