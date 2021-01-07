<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/7/2021
  Time: 12:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <header>
        <h2>your Gold</h2>

        <div><c:out value="${sessionScope.yourGold}"/> &#x1F3C5;</div>
    </header>
    <main>
        <div>
            <h2>Farm</h2>
            <p>(earns 10-20 golds)</p>
            <form action="processMoney" method="post">
                <input type="hidden" name="which_form" value="farm">
                <button type="submit">Find Gold!</button>
            </form>
        </div>
        <div>
            <h2>Cave</h2>
            <p>(earns 5-10 golds)</p>
            <form action="processMoney" method="post">
                <input type="hidden" name="which_form" value="cave">
                <button type="submit">Find Gold!</button>
            </form>
        </div>
        <div>
            <h2>House</h2>
            <p>(earns 2-5 golds)</p>
            <form action="processMoney" method="post">
                <input type="hidden" name="which_form" value="house">
                <button type="submit">Find Gold!</button>
            </form>
        </div>
        <div>
            <h2>Casino</h2>
            <p>(earns/takes 0-50 golds)</p>
            <form action="processMoney" method="post">
                <input type="hidden" name="which_form" value="casino">
                <button type="submit">Find Gold!</button>
            </form>
        </div>
    </main>
    <footer>
        <h3>Activities:</h3>
        <div class="log">
            <c:forEach var="log" items="${sessionScope.log}">
            <p style="color:<c:out value="${log.color}"/>"><c:out value="${log.massage}"/></p>
            </c:forEach>
        </div>
    </footer>
</body>
</html>
