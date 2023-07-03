<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/7/2
  Time: 9:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品管理系统主页</title>
</head>
<body>
<table>
    <tr>
        <td>商品编号</td>
        <td>商品名称</td>
        <td>商品价格</td>
        <td>商品类型</td>
        <td>操作</td>
    </tr>
    <jsp:useBean id="plist" scope="request" type="java.util.List"/>
    <c:forEach items="${plist}" var="product">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.productPrice}</td>
            <td>${product.category.categoryName}</td>
            <td>
                <a href="deleteById.action?productId=${product.productId}">删除</a>
                <a href="beforeUpdate.action?productId=${product.productId}">修改</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5">
            <a href="beforeAddProduct.action">添加商品</a>
        </td>
    </tr>
</table>
</body>
</html>
