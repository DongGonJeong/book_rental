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
                <h1 class="h2">도서 등록</h1>
            </div>

            <form action="/book/add" method="post">

                <label for="name">도서이름:</label><input type="text" name="name" id="name"><br>

                <label for="writer">저자:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="writer" id="writer"><br>

                <label for="publication_dt">출판일자: </label><input type="text" name="publication_dt" id="publication_dt"><br>

                <label for="price">가격:</label>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="price"
                                                        id="price"><br>

                <input type="submit">
            </form>

        </main>
    </div>
</div>

<jsp:include page="../include/required_footer.jsp"></jsp:include>