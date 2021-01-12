<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/12/2021
  Time: 11:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>${question.context}</h1>
    <p>Tags:</p>
    <ul>
    <c:forEach items="${question.tags}" var="tag">
        <li><c:out value="${tag.subject}"/></li>
    </c:forEach>
    </ul>
    <div class="bg-light p-5 rounded">
        <table class="table table-hover table-striped table-bordered table-dark">
            <thead>
            <tr>
                <th scope="col">Answers</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${question.answers}" var="ans">
                <tr>
                    <td><c:out value="${ans.context}"/></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <h2>Add Your Answer</h2>
    <form:form action="/questions/${question.id}" method="post" modelAttribute="answer">
        <p>
            <form:label path="context">Your Answer:</form:label>
            <form:errors path="context"/>
            <form:input path="context"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
