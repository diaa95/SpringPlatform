<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/11/2021
  Time: 2:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>All Categories</h1>
<table>
    <thead>
    <tr>
        <th>Category's Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${categories}" var="category">
        <tr>
            <td><a href="categories/${category.id}"><c:out value="${category.name}"/></a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
