<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/10/2021
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Person</title>
</head>
<body>
    <h1><c:out value="${person.firstname}"/> <c:out value="${person.lastname}"/></h1>
    <ul>
            <li>License Number: <c:out value="${person.license.getStringNumber}"/></li>
            <li>State: <c:out value="${person.license.state}"/></li>
            <li>Expiration Date: <c:out value="${person.license.stringExpirationDate}"/></li>
    </ul>
</body>
</html>
