<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/11
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link href="css/login.css" rel="stylesheet">
</head>
<body>
<form action="login.action">
    <table>
        <tr>
            <td>用户ID</td>
            <td><label for="userId"></label><input type="text" name="userId" id="userId"></td>
        </tr>
        <tr>
            <td>用户密码</td>
            <td><label for="password"></label><input type="password" name="password" id="password"></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="登录"><input type="reset" value="重置"></td>
        </tr>
    </table>
</form>
</body>
</html>
