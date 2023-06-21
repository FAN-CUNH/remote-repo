<%@ page import="java.util.Arrays" %><%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/4
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="./js/jquery-1.11.0.min.js"></script>
    <script>
        $(function () {
            console.log("用户登录验证");
            $("form").submit(function () {
                // 1.获取数据
                const stuNo = $("#stuNo").val();
                const password = $("#password").val();
                // 2.处理数据
                if (stuNo == null || stuNo === "") {
                    alert("stuNo is not null")
                    return false;
                }
                if (password == null || password === "") {
                    alert("password is not null")
                    return false;
                }
                // 3.响应结果
                return true;
            })
        })
    </script>
</head>
<body>
    <%
        /*
         *   cookie:
         *          从客户端获取cookie信息
         *          将信息赋值给stuNo
         */
        String stuNo = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                String cookieName = cookie.getName();
                if (cookieName.equals("stuNo")) {
                    stuNo = cookie.getValue();
                    System.out.println("后端获取得到的cookie值：" + stuNo);
                    break;
                }
            }
        }
    %>
<form action="load.action">
    <div>
        学号：<label></label><input type="text" name="stuNo" value="<%=stuNo%>" id="stuNo"><label>记住学号：<input type="checkbox" name="remember">
    </label>
    </div>
    <div>
        密码：<label for="password"></label><input type="password" name="password" id="password">
    </div>
    <div>
        <input type="submit" value="登录">
        <input type="reset" value="重置">
    </div>
</form>
</body>
</html>
