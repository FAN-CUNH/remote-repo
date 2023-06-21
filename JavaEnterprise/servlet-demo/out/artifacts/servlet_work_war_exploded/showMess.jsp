<%@ page import="java.util.Map" %>
<%@ page import="com.fch.bean.Page" %><%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/4
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Page<Map<String, Object>> pageCon = (Page<Map<String, Object>>) session.getAttribute("page");%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="#fff" style="align-content: center;">
    <tr> <th>学号</th> <th>姓名</th> <th>课程编号</th> <th>课程名称</th> <th>删除课程</th> </tr>
    <%for(Map<String, Object> student : pageCon.getData()){%>
        <tr>
            <td><%=student.get("stuNo")%></td>
            <td><%=student.get("stuName")%></td>
            <td><%=student.get("couNo")%></td>
            <td><%=student.get("couName")%></td>
            <td>
                <form action="delCourses.action">
                    <input type="hidden" value="<%=student.get("stuNo")%>" name="stuNo">
                    <input type="hidden" value="<%=student.get("couNo")%>" name="couNo">
                    <input type="submit" value="删除">
                </form>
            </td>
            <td>
                <form action="getOneStudent.action">
                    <input type="hidden" value="<%=student.get("stuNo")%>" name="stuno">
                    <input type="submit" value="更新">
                </form>
            </td>
        </tr>
    <%}%>
    <tr>
        <th> <a href="getMess.action?currentPage=<%=pageCon.getCurrentPage()-1%>"><%="上一页"%> </th>
        <th>
                <% for (int i = 1; i <= pageCon.getPageSize(); i++) {%>
                    <%if (pageCon.getCurrentPage() == i) {%>
                        <a href="getMess.action?currentPage=<%=i%>" style="color: red"><%=i%></a>
                    <%}
                    else{%>
                        <a href="getMess.action?currentPage=<%=i%>"><%=i%></a>
                    <%}
                }%>
        </th>
        <th> <a href="getMess.action?currentPage=<%=pageCon.getCurrentPage()+1%>"><%="下一页"%> </th>
        <th> <a href="getMess.action?currentPage=<%=pageCon.getPageSize()%>"><%="到底"%></a></th>
    </tr>
</table>
</body>
</html>
