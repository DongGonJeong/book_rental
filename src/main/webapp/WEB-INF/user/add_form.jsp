<%--
  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2023-05-12
  Time: 오전 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>add_form</title>
</head>

<body>

<form action="/user/add" method="post">

    <label for="name">이름: </label><input type="text" name="name" id="name"><br>

    <label for="age">나이: </label><input type="text" name="age" id="age"><br>

    <label for="hp">전화번호: </label><input type="text" name="hp" id="hp"><br>

    <label for="address">주소: </label><input type="text" name="address"
                                        id="address"><br>

    <input type="submit">


</form>
</body>
</html>
