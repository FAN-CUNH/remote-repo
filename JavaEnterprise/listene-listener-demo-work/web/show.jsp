<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/6
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String mess = (String) session.getAttribute("mess");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<input type="text" value="<%=mess%>">
<div><h1>${mess}</h1></div>
</body>
</html>
