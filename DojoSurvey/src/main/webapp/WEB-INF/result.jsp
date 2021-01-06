<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/6/2021
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>result</title>
</head>
<body>
<center>
    <h1>Submitted Info</h1>
    <ul>
        <li>Name: <c:out value="${sessionScope.name}"/></li>
        <li>Dojo Location: <c:out value="${sessionScope.location}"/></li>
        <li>Favorite Language: <c:out value="${sessionScope.language}"/></li>
        <li>Comment: <c:out value="${sessionScope.comment}"/></li>
    </ul>
</center>

</body>
</html>
