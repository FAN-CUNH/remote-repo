<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/4
  Time: 15:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="register.action">
    <table>
        <tr><td>学号</td><td><label for="stuNo"></label><input type="text" name="stuNo" id="stuNo"></td></tr>
        <tr><td>姓名</td><td><label for="stuName"></label><input type="text" name="stuName" id="stuName"></td></tr>
        <tr><td>密码</td><td><label for="password"></label><input type="password" name="password" id="password"></td></tr>
        <tr><td><input type="submit" value="注册"></td><td><input type="reset" value="重置"></td></tr>
    </table>
</form>
</body>
</html>
