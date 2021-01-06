<%--
  Created by IntelliJ IDEA.
  User: Diaa
  Date: 1/6/2021
  Time: 11:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form</title>
</head>
<body>
    <center>
        <form action="/result" method="post">
            <label>Your Name:  <input type="text" name="name"></label><br>
            <label>Dojo Location: <select name="location">
                <option value="palestine">Palestine</option>
                <option value="sanJose">San Jose</option>
                <option value="burbank">Burbank</option>
            </select></label><br>
            <label>Language: <select name="language">
                <option value="python">Python</option>
                <option value="java">Java</option>
                <option value="mern">Mern</option>
            </select></label><br>
            <label for="comment">Comment<span style="font-style: italic">(optional)</span></label><br>
            <input id="comment" name="comment" type="text"><br>
            <button type="submit">Submit</button>
        </form>
    </center>
</body>
</html>
