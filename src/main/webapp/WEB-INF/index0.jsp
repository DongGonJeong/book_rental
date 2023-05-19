<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--    <%@ include file="include/required_header.jsp"%>--%>
    <jsp:include page="./include/required_header.jsp"></jsp:include>

</head>

<body>

<jsp:include page="./include/inc_header.jsp"></jsp:include>

<div class="container-fluid">
    <div class="row">

        <jsp:include page="./include/inc_sidebar.jsp"></jsp:include>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">도서관리 pj</h1>
            </div>

        </main>
    </div>
</div>

<jsp:include page="./include/required_footer.jsp"></jsp:include>

</body>
</html>
