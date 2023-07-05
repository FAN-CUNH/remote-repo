<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/7/4
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%if (request.getAttribute("students")==null){
    request.getRequestDispatcher("findAll").forward(request, response);
}%>
<html>
<head>
    <title>首页</title>
    <c:if test="${msg!=null and msg!=''}">
        <script>alert(${msg});</script>
    </c:if>
    <script src="/static/mian.js"></script>
</head>
<body>
<table>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>年龄</td>
        <td>地址</td>
        <td>操作</td>
    </tr>
    <jsp:useBean id="students" scope="request" type="java.util.List"/>
    <c:forEach items="${students}" var="s">
        <tr>
            <td>${s.stuId}</td>
            <td>${s.stuName}</td>
            <td>${s.stuAge}</td>
            <td>${s.address}</td>
            <td><a href="delete?stuId=${s.stuId}">删除</a><a href="find?stuId=${s.stuId}">修改</a></td>
        </tr>
    </c:forEach>
</table>
<a href="add.jsp">新增</a>
</body>
</html>
