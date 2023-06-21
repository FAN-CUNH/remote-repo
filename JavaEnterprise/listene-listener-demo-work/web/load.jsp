<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/5
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div>
        <form action="load.action">
            <table border="#fff">
                <tr><td>用户名：</td><td><input type="text" name="userID"></td></tr>
                <tr><td>密码：</td><td><input type="password" name="password"></td></tr>
                <tr><td><input type="submit" value="登录"></td><td><input type="reset" value="重置"></td></tr>
            </table>
        </form>
    </div>
</body>
</html>
