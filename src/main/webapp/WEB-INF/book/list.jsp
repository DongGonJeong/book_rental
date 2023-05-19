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

<%----------------------------------------------------------------------------------%>

<jsp:include page="../include/required_header.jsp"></jsp:include>

<link rel="stylesheet" href="//cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css">

<style>
    .btn-delete {

        /*background-color:goldenrod !important;*/
    }
</style>

</head>

<body>

<jsp:include page="../include/inc_header.jsp"></jsp:include>

<div class="container-fluid">
    <div class="row">

        <jsp:include page="../include/inc_sidebar.jsp"></jsp:include>

        <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">도서 목록</h1>
            </div>

            <table id="myTable">

                <thead>
                <tr>
                    <th>도서 번호</th>
                    <th>도서 이름</th>
                    <th>저자</th>
                    <th>출판일자</th>
                    <th>가격</th>

                    <th></th>
                </tr>
                </thead>

                <tbody>
                <c:forEach var="book" items="${book_list}">

                    <tr>
                        <td>${book.book_no}</td>
                        <td>${book.name}</td>
                        <td>${book.writer}</td>
                        <td>${book.publication_dt}</td>
                        <td>${book.price}</td>

                        <td>
                            <input type="button" value="수정" class="btn btn-modify" style="background-color: lightskyblue;" onclick="update_book(${book.book_no}, 'U')">


                            <input type="button" value="삭제"
                                   class="btn btn-delete" style="background-color: lightpink" onclick="update_book(${book.book_no}, 'D')">
                        </td>

                    </tr>

                </c:forEach>

                </tbody>
            </table>
        </main>

        <form action="/book/update" method="post" id="_frm">
            <input type="hidden" name="book_no" id="_book_no">
            <input type="hidden" name="type" id="_type">
        </form>
    </div>
</div>

<jsp:include page="../include/required_footer.jsp"></jsp:include>

<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>--%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.0/jquery.js"></script>

<script src="//cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>

<script>
    $(document).ready(

        function() {

            $('#myTable').DataTable();
        }
    );

    function update_book(book_no, type) {

        $('#_book_no').val(book_no);

        $('#_type').val(type);

        // if(type == "D") {
        //     if(confirm("정말 삭제하시겠습니까?")) {
        //         $('#_frm').submit();
        //     } else {
        //         return;
        //     }
        // }
        if(confirm("정말 " + (type=="U"?"수정":"삭제") + "하시겠습니까?")) {

            $('#_frm').submit();

        }
    }


</script>