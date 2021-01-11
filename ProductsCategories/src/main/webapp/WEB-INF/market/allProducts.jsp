<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/11/2021
  Time: 3:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All Products</h1>
<table>
    <thead>
    <tr>
        <th>Product's Name</th>
        <th>Product's Description</th>
        <th>Product's Price</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td><a href="products/${product.id}"><c:out value="${product.name}"/></a></td>
            <td><c:out value="${product.description}"/></td>
            <td><c:out value="${product.price}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
