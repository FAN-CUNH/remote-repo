<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/7/4
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>添加学生页面</title>
</head>
<body>
<form action="insert" method="post">
    <label>
        <input type="text" name="stuName" placeholder="请输入学生姓名">
    </label>
    <label>
        <input type="text" name="stuAge" placeholder="请输入学生年龄">
    </label>
    <label>
        <input type="text" name="address" placeholder="请输入学生住址">
    </label>
    <input type="submit" value="新增">
    <input type="button" value="返回" onclick="history.back()">
</form>
</body>
</html>
