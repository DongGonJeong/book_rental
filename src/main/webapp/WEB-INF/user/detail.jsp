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
                <h1 class="h2">회원 상세 정보</h1>
            </div>

            <table>
                <tr>
                    <th>이름</th> <td>${userInfo.name}</td>
                </tr>

                <tr>
                    <th>나이</th> <td>${userInfo.age}</td>
                </tr>

                <tr>
                    <th>전화번호</th> <td>${userInfo.hp}</td>
                </tr>

                <tr>
                    <th>주소</th> <td>${userInfo.address}</td>
                </tr>
            </table>

        </main>


    </div>
</div>

<jsp:include page="../include/required_footer.jsp"></jsp:include>