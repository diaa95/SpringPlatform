<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/4/2021
  Time: 11:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
    <title>Date</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/scriptdate.js"></script>
</head>
<body>
    <c:set var="Date" value="<%=new java.util.Date()%>"/>
    <p class="date">The Date is: <fmt:formatDate type="date" dateStyle="long" value="${Date}"/></p>
</body>
</html>
