<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/5/2021
  Time: 9:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>The Code</title>
</head>
<body>
    <c:out value="${error}"/>
    <form action="/check" method="post">
        <label>What is the Code? <input type="text" name="code"></label>
        <button type="submit">Try Code</button>
    </form>
</body>
</html>
