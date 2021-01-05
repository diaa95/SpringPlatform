<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/5/2021
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Counter</title>
</head>
<body>
    <h1>You Visited <a href="/home">Home</a> <c:out value="${sessionScope.count}"/> Times</h1>
    <a href="/">Test another visit</a><br>
    <a href="/double">Test double Count</a><br>
    <a href="/destroy">Delete Count</a>
</body>
</html>
