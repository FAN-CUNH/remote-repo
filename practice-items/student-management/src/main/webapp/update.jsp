<jsp:useBean id="student" scope="request" type="com.fch.domain.Student"/>
<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/7/4
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>更新页面</title>
</head>
<body>
<form action="update" method="post">
  <label>
    <input type="text" name="stuId" value="${student.stuId}" readonly>
  </label>
  <label>
    <input type="text" name="stuName" value="${student.stuName}">
  </label>
  <label>
    <input type="text" name="stuAge" value="${student.stuAge}">
  </label>
  <label>
    <input type="text" name="address" value="${student.address}">
  </label>
  <input type="submit" value="保存">
  <input type="button" value="返回" onclick="history.back()">
</form>
</body>
</html>
