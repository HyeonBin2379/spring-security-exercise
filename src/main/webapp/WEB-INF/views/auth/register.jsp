<%--
  Created by IntelliJ IDEA.
  User: a
  Date: 2025-10-28
  Time: 오후 4:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Page</title>
</head>
<body>
    <h1>Register Page</h1>
    <form name="registerForm"  action="/auth/register" method="post">
        <div>
            <input type="text" name="userId" id="userId" placeholder="ID" required/>
        </div>
        <div>
            <input type="password" name="userPwd" id="userPwd" placeholder="PASSWORD" required/>
        </div>
        <div>
            <input type="text" name="userName" id="userName" placeholder="NAME" required>
        </div>
        <div>
            <input type="hidden" name="userRole" id="userRole" value="${userRole}">
        </div>
        <div>
            <button type="submit">REGISTER</button>
        </div>
    </form>
    <button onclick="location.href='/index'">HOME PAGE</button>
</body>
</html>
