<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/12/2021
  Time: 6:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table class="table table-hover table-striped table-bordered table-dark">
        <thead>
        <tr>
            <th scope="col">Question</th>
            <th scope="col">Tags</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${questions}" var="question">
            <tr>
                <td><a href="/questions/${question.id}"><c:out value="${question.context}"/></a></td>
                <td>
                    <c:forEach items="${question.tags}" var="tag">
                        <c:out value="${tag.subject}"/>,
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</body>
<p>Add a Question</p>
<a href="/addQuestion">New</a>
</html>
