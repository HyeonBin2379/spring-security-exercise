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
    <form name="registerForm">
        <div>
            <input type="text" name="mID" id="mID" placeholder="ID"/>
        </div>
        <div>
            <input type="password" name="mPassword" id="mPassword" placeholder="PASSWORD"/>
        </div>
        <div>
            <input type="text" name="mName" id="mName" placeholder="NAME">
        </div>
        <div>
            <button type="submit" formaction="/member/register" formmethod="post">REGISTER</button>
        </div>
    </form>
    <button onclick="location.href='/'">HOME PAGE</button>
</body>
</html>
