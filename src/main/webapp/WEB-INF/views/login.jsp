<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 2025-11-02
  Time: 오후 1:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Login Page</h1>
    <form action="/loginProcess" method="post" name="loginForm">
        <div>
            <input type="text" name="mid" id="mid" placeholder="ID"/>
        </div>
        <div>
            <input type="password" name="mpw" id="mpw" placeholder="PASSWORD"/>
        </div>
        <div>
            <button type="submit">LOGIN</button>
        </div>
    </form>
    <button onclick="location.href='/member/register-select'">REGISTER</button>
</body>
</html>
