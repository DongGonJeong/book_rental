<%--
  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2023-05-12
  Time: 오전 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%------------------------------------------------------------------%>

<jsp:include page="../include/required_header.jsp"></jsp:include>

</head>

<body>

<jsp:include page="../include/inc_header.jsp"></jsp:include>

<div class="container-fluid">
    <div class="row">

        <jsp:include page="../include/inc_sidebar.jsp"></jsp:include>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">회원 정보 수정</h1>
            </div>

            <form action="/user/update_process" method="post">

                <label for="name">이름: </label><input type="text" name="name" id="name" value="${userInfo.name}"><br>

                <label for="age">나이: </label><input type="text" name="age" id="age" value="${userInfo.age}"><br>

                <label for="hp">전화번호: </label><input type="text" name="hp" id="hp" value="${userInfo.hp}"><br>

                <label for="address">주소: </label><input type="text" name="address"
                                                        id="address" value="${userInfo.address}"><br>

                <input type="hidden" name="user_no" value="${userInfo.user_no}">

                <input type="submit">
            </form>

        </main>
    </div>
</div>

<jsp:include page="../include/required_footer.jsp"></jsp:include>