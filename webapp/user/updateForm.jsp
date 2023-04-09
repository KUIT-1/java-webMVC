<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="ko">
  <%@ include file="../include/header.jspf" %>
  <body>
  <%@ include file="../include/navigation.jspf" %>

    <div class="container" id="main">

        <main class="form-update">

          <form name="update" method="post" action="/user/update">
            <div class="form-floating">
              <input readonly type="text" value="${user.userId}" class="form-control" id="userId" name="userId" placeholder="Id">
              <label for="userId">${user.userId}</label>
            </div>
            <div class="form-floating">
              <input type="password" value="${user.password}" class="form-control" id="password" name="password" placeholder="Password">
              <label for="password">Password: ${user.password}</label>
            </div>
            <div class="form-floating">
              <input type="text" value="${user.name}" class="form-control" id="name" name="name" placeholder="name">
              <label for="name">Name: ${user.name}</label>
            </div>
            <div class="form-floating">
              <input type="email" value="${user.email}" class="form-control" id="email" name="email" placeholder="name@example.com">
              <label for="email">Email: ${user.email}</label>
            </div>
            <div style="height:10px;">
            </div>
            <button class="w-100 btn btn-lg btn-primary" type="submit">Update</button>
          </form>
        </main>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="../js/scripts.js"></script>
  </body>
</html>