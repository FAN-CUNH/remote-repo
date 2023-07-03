<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/7/2
  Time: 14:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>添加商品页面</title>
</head>
<form action="addProduct.action" method="post">
    <label>
        <input type="text" name="productName" placeholder="请输入商品名称">
    </label>
    <label>
        <input type="text" name="productPrice" placeholder="请输入商品价格">
    </label>
    <label>
        <select name="categoryId">
            <jsp:useBean id="categories" scope="request" type="java.util.List"/>
            <c:forEach items="${categories}" var="category">
                <option value="${category.categoryId}">${category.categoryName}</option>
            </c:forEach>
        </select>
        <input type="submit" value="保存">
        <input type="button" value="返回" onclick="history.back()">
    </label>
</form>
<body>

</body>
</html>
