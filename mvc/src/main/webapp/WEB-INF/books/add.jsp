<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/6/2021
  Time: 3:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add</title>
</head>
<body>
    <form action="/api/books" method="post">
        <label>Title: <input type="text" name="title"></label>
        <label>Description: <input type="text" name="description"></label>
        <label>Language: <input type="text" name="language"></label>
        <label>Number Of Pages: <input type="number" name="pages"></label>
        <button type="submit">Add Book</button>
    </form>
</body>
</html>
