<%--
  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2023-05-13
  Time: 오전 12:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>user list</title>
</head>

<body>

    <table>

        <thead>
            <tr>
                <th>회원명</th>
                <th>나이</th>
                <th>전화번호</th>
                <th>주소</th>
                <th>대여상태</th>
                <th>사유</th>
                <th>최대대여가능권수</th>
                <th>현재대여권수</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="user" items="${user_list}">

                <tr>
                    <td>${user.user_no}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>${user.hp}</td>
                    <td>${user.address}</td>
                    <td>${user.status}</td>
                    <td>${user.status_reason}</td>
                    <td>${user.max_count}</td>
                    <td>${user.on_rental_count}</td>

                </tr>

            </c:forEach>

        </tbody>
    </table>



</body>
</html>
