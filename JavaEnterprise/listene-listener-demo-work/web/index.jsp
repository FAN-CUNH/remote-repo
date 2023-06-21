<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/5
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>统计在线人数</title>
  </head>
  <body>
      <div>
        <a href="removedSession.action">退出</a> &nbsp&nbsp 在线人数：${online}
      </div>
      <br><br><br>
      <div>
        <form action="load.jsp">
            <input type="submit" value="登录">
        </form>
      </div>
      <div>
          <form action="regist.jsp">
             <input type="submit" value="注册">
          </form>
      </div>
  </body>
</html>
