<%--
  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2023-05-12
  Time: 오전 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-------------------------------------------------------------------------------%>

<jsp:include page="../include/required_header.jsp"></jsp:include>

</head>

<body>

<jsp:include page="../include/inc_header.jsp"></jsp:include>

<div class="container-fluid">
    <div class="row">

        <jsp:include page="../include/inc_sidebar.jsp"></jsp:include>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">회원 main</h1>
            </div>

            <a href="/user/user_add">회원 등록하러 가기</a>

        </main>
    </div>
</div>

<jsp:include page="../include/required_footer.jsp"></jsp:include>