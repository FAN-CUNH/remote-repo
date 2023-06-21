<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/6
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script>
        $(function () {
            // 点击验证码 刷新验证码
            $("img").click(function () {
                this.src = "user/getCode.action?time = " + new Date();
            })

            // 动态验证验证码
            $("#code").keyup(function () {
                var $code = $("#code").val();
                console.log($code)
                // ajax
                $.ajax({
                    url: "checkCodeIsRight.action",
                    data: {"code": $code},
                    success(data) {
                        console.log(data)
                        if (data === "true") {
                            // 登录按钮可点击
                            $("#loadButt").attr('disabled', false);
                            console.log("可点击")
                        } else {
                            $("#loadButt").attr('disabled', true);
                            console.log("不可点击")
                        }
                    },
                    dataType: "json"
                })
            })
        })
    </script>
</head>
<body>
<form action="load.action">
    用户名：
    <label>
        <input type="text" name="userId">
    </label>
    密码：
    <label>
        <input type="password" name="password">
    </label>
    <label for="code"></label><input type="text" name="code" id="code"><img src="user/getCode.action" alt="验证码">
    <input type="submit" value="登录" id="loadButt" disabled>
    <input type="reset" value="重置">
</form>
</body>
</html>
