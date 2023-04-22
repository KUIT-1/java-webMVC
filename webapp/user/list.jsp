<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collection" %>
<%@ page import="jwp.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="ko">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>KUIT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/styles.css" rel="stylesheet">
</head>
<body>
<%@ include file="/include/navigation.jspf" %>
<%@ include file="/include/header.jspf" %>

<div class="container" id="main">
    <table class="table table-striped">
        <thead class="col-md-12">
        <tr>
            <th class="col-md-3">아이디</th>
            <th class="col-md-3">이름</th>
            <th class="col-md-3">이메일</th>
            <th class="col-md-3">#</th>

        </tr>
        </thead>
        <tbody>
        <%
            Collection<User> users = (Collection<User>) request.getAttribute("users");
            for (User user : users) {
        %>
        <tr>
            <th class="col-md-3"><%= user.getUserId() %>
            </th>
            <th class="col-md-3"><%= user.getName() %>
            </th>
            <th class="col-md-3"><%= user.getEmail() %>
            </th>
            <form action="/user/updateForm" method="get">

                <input type="hidden" id="userId" name="userId" value="<%= user.getUserId() %>">
                <th class="col-md-3">
                    <button class="btn btn-success" type="submit">수정</button>
                </th>
            </form>

        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<script src="../js/scripts.js"></script>
</body>
</html>