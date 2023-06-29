<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/28
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" pageEncoding="UTF-8" import="java.util.*"  %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="updateProduct.action" method="post">
  <label>
    <input type="text" placeholder="请输入商品ID" name="pid" value="${product.pid}">
  </label>
  <label>
    <input type="text" placeholder="请输入商品名称" name="pname" value="${product.pname}">
  </label>
  <label>
    <input type="number" placeholder="请输入商品价格" name="marketPrice" value="${product.marketPrice}">
  </label>
  <label>
    <select name="cid">
      <c:forEach items="${category}" var="category">
        <option value="${category.cid}" <c:if test="${category.cid==product.cid}">selected</c:if> >
            ${category.cname}
        </option>
      </c:forEach>
    </select>
  </label>
  <input type="submit" value="保存"><input type="button" value="返回" onclick="history.back()">
</form>
</body>
</html>
