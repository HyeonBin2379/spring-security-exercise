<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2025-11-02
  Time: 오후 7:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Register Type Select</h1>
    <form action="/auth/register" name="registerSelect" method="get">
        <div>
            <label for="roleChoice1">고객사</label>
            <input type="radio" name="mRole" id="roleChoice1" value="COMPANY" checked>
        </div>
        <div>
            <label for="roleChoice2">창고관리자</label>
            <input type="radio" name="mRole" id="roleChoice2" value="MANAGER">
        </div>
        <div>
            <label for="roleChoice3">총관리자</label>
            <input type="radio" name="mRole" id="roleChoice3" value="ADMIN">
        </div>
        <div>
            <button type="submit">SELECT</button>
        </div>
    </form>
    <button onclick="location.href='/index'">HOME PAGE</button>
</body>
</html>
