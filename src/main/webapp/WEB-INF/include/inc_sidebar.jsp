<%--
  Created by IntelliJ IDEA.
  User: Jeong
  Date: 2023-05-14
  Time: 오후 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-body-tertiary sidebar collapse">
    <div class="position-sticky pt-3 sidebar-sticky">
        <ul class="nav flex-column">

            <li class="nav-item">
                <a class="nav-link active" aria-current="page"
                   href="/user">
                    <span data-feather="home" class="align-text-bottom"></span>
                    회원
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link active" aria-current="page"
                   href="/user/user_add">
                    <span data-feather="home" class="align-text-bottom"></span>
                    &nbsp;&nbsp;회원 등록
                </a>
            </li>

            <li class="nav-item">
                <a class="nav-link active" aria-current="page"
                   href="/user/list">
                    <span data-feather="home" class="align-text-bottom"></span>
                    &nbsp;&nbsp;회원 목록
                </a>
            </li>


        </ul>


    </div>
</nav>
