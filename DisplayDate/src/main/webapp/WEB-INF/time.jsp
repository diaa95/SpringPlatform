<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/5/2021
  Time: 1:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Time</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/scripttime.js"></script>
</head>
<body>
    <c:set var="Date" value="<%=new java.util.Date()%>"/>
    <p class="time">The Time is: <fmt:formatDate type="time" timeStyle="short" value="${Date}"/></p>
</body>
</html>
