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
                <h1 class="h2">회원 목록</h1>
            </div>

            <table id="myTable">

                <thead>
                <tr>
                    <th>회원번호</th>
                    <th>회원명</th>
                    <th>나이</th>
                    <th>전화번호</th>
                    <th>주소</th>
                    <th>대여상태</th>
                    <th>사유</th>
                    <th>최대대여가능권수</th>
                    <th>현재대여권수</th>

                    <th></th>
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

                        <td>
                            <input type="button" value="수정" class="btn btn-modify" style="background-color: lightskyblue;" onclick="update_user(${user.user_no}, 'U')">


                            <input type="button" value="삭제"
                                   class="btn btn-delete" style="background-color: lightpink" onclick="delete_user(${user.user_no}, 'D')">
                        </td>

                    </tr>

                </c:forEach>

                </tbody>
            </table>

        </main>
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
    )
</script>