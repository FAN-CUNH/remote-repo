<%@ page import="java.util.Map" %>
<%@ page import="com.fch.bean.Page" %><%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/6
  Time: 14:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Page<Map<String, Object>> proPage = (Page<Map<String, Object>>) session.getAttribute("page");%>

<html>
<head>
    <title>展示商品信息页面</title>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script>
        $(function () {
            // 清空页面
            // 输入框边输入边查
            $("#pid").keyup(function () {
                $("#t2").html("<tr>" +
                    "        <td><input type='checkbox' id='selectAll'>全选/全不选</td>" +
                    "        <td>商品id</td>" +
                    "        <td>商品名称</td>" +
                    "        <td>类别名称</td>" +
                    "        <td>操作</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td colspan='5' align='right'>" +
                    "            <button>批量删除</button>" +
                    "        </td>" +
                    "    </tr>")
                $.ajax({
                    url: "selectProduct.action",
                    data: {pid: $("#pid").val(), pname: $("#pname").val()},
                    dataType: "json",
                    success(result) {
                        console.log(JSON.stringify(result))
                        if (result) {
                            for (let i = 0; i < result.length; i++) {
                                console.log(result.length)
                                $("#t2").append(
                                    "<tr>" +
                                    "<td>" +
                                    "       <label>" +
                                    "           <input type=\"checkbox\" class=\"c1\">" +
                                    "       </label>" +
                                    "   </td>" +
                                    "   <td>" + result[i].pid + "</td>" +
                                    "   <td>" + result[i].pname + "</td>" +
                                    "   <td>" + result[i].cname + "</td>" +
                                    "   <td>" +
                                    "       <form action=\"deleteProductByPid.action\">\n" +
                                    "                <input type=\"hidden\" name=\"dele\" value= " + result[i].pid + ">\n" +
                                    "                <input type=\"submit\" value=\"删除\">\n" +
                                    "       </form>" +
                                    "   </td>" +
                                    "</tr>");
                            }
                        }
                    }
                })
            })

            $("#pname").change(function () {
                $("#t2").html("<tr>" +
                    "        <td><input type='checkbox' id='selectAll'>全选/全不选</td>" +
                    "        <td>商品id</td>" +
                    "        <td>商品名称</td>" +
                    "        <td>类别名称</td>" +
                    "        <td>操作</td>" +
                    "    </tr>" +
                    "    <tr>" +
                    "        <td colspan='5' align='right'>" +
                    "            <button>批量删除</button>" +
                    "        </td>" +
                    "    </tr>")
                $.ajax({
                    url: "selectProduct.action",
                    data: {pid: $("#pid").val(), pname: $("#pname").val()},
                    dataType: "json",
                    success(result) {
                        console.log(JSON.stringify(result))
                        if (result) {
                            for (let i = 0; i < result.length; i++) {
                                console.log(result.length)
                                $("#t2").append(
                                    "<tr>" +
                                    "<td>" +
                                    "       <label>" +
                                    "           <input type=\"checkbox\" class=\"c1\">" +
                                    "       </label>" +
                                    "   </td>" +
                                    "   <td>" + result[i].pid + "</td>" +
                                    "   <td>" + result[i].pname + "</td>" +
                                    "   <td>" + result[i].cname + "</td>" +
                                    "   <td>" +
                                    "       <form action=\"deleteProductByPid.action\">\n" +
                                    "                <input type=\"hidden\" name=\"dele\" value= " + result[i].pid + ">\n" +
                                    "                <input type=\"submit\" value=\"删除\">\n" +
                                    "       </form>" +
                                    "   </td>" +
                                    "</tr>");
                            }
                        }
                    }
                })
            })

            // 点击批量删除按钮是，获取所有被勾选商品的 pid
            $("#deleAll").click(function () {
                var str = [];
                $(".c1").each(function () {
                    if ($(this).is(":checked")) {
                        str.push(($(this).parent().parent().parent().find("td:eq(" + 1 + ")")).text());
                        console.log(($(this).parent().parent().parent().find("td:eq(" + 1 + ")")).text())
                    }
                });
                console.log(str)
                $.ajax({
                    url: "deleteAllProductById.action",
                    data: {'str': str},
                    dataType: "json",
                    traditional: true,
                    success: function () {

                    }
                })
                // 刷新
                location.reload();
            });

            // 全选、全不选
            $("#selectAll").click(function () {
                if ($(this).is(":checked")) {
                    $(".c1").prop("checked", true)
                    //console.log("已勾选的商品pid：" + ($(this).parent().parent().parent().find("td:eq(" + 1 + ")")).text())
                } else {
                    $(".c1").prop("checked", false)
                }
            });

            // 勾选商品，显示商品具体信息
            $(".c1").click(function () {
                if ($(this).is(":checked")) {
                    var $pid = ($(this).parent().parent().parent().find("td:eq(" + 1 + ")")).text();
                    console.log("已勾选的商品pid：" + ($(this).parent().parent().parent().find("td:eq(" + 1 + ")")).text())
                }
                $("#t3").html("");
                $.ajax({
                    url: "showCheckedMess.action",
                    data: {pid: $pid},
                    dataType: "json",
                    success(result) {
                        console.log(result)
                        console.log(result.pid)
                        console.log(result.pimage)
                        console.log(result.market_price)
                        $("#t3").append(
                            "                        <tr>\n" +
                            "                        <td>商品Id:</td>\n" +
                            "                        <td><label>\n" +
                            "                        <input type=\"text\" disabled value=" + result.pid + ">\n" +
                            "                            </label></td>\n" +
                            "                        </tr>\n" +
                            "                        <tr>\n" +
                            "                        <td>商品图片:</td>\n" +
                            "                        <td><img src=\"" + result.pimage + "\"></td>\n" +
                            "                            </tr>\n" +
                            "                            <tr>\n" +
                            "                            <td>商品价格:</td>\n" +
                            "                        <td><label>\n" +
                            "                        <input type=\"text\" disabled value=\"" + result.market_price + "\">\n" +
                            "                            </label></td>\n" +
                            "                        </tr>\n")
                    }
                })
            })
        })
    </script>
</head>
<body>
<table>
    <tr>
        <td>商品Id:</td>
        <td><label>
            <input type="text" name="pid" id="pid" placeholder="商品ID可以不输入">
        </label></td>
        <td>商品名称：</td>
        <td><label>
            <input type="text" name="pname" id="pname" placeholder="商品名称可以不输入">
        </label></td>
        <td>
            <button id="seleButt">搜索商品</button>
        </td>
        <td><a href="addProduct.jsp">添加商品</a></td>
    </tr>
</table>

<table id="t2">
    <tr>
        <td><label for="selectAll"></label><input type="checkbox" id="selectAll">全选/全不选</td>
        <td>商品id</td>
        <td>商品名称</td>
        <td>类别名称</td>
        <td>操作</td>
    </tr>
    <%for (Map<String, Object> pro : proPage.getData()) {%>
    <tr>
        <td>
            <label>
                <input type="checkbox" class="c1">
            </label>
        </td>
        <td><%=pro.get("pid")%>
        </td>
        <td><%=pro.get("pname")%>
        </td>
        <td><%=pro.get("cname")%>
        </td>
        <td>
            <form action="deleteProductByPid.action">
                <input type="hidden" name="dele" value=<%=pro.get("pid")%>>
                <input type="submit" value="删除">
            </form>
        </td>
    </tr>
    <%}%>
    <tr>
        <th><a href="getMess.action?currentPage=<%=proPage.getCurrentPage()-1%>"><%="上一页"%>
        </th>
        <th>
            <% for (int i = 1; i <= proPage.getPageSize(); i++) {%>
            <%if (proPage.getCurrentPage() == i) {%>
            <a href="getMess.action?currentPage=<%=i%>" style="color: red"><%=i%>
            </a>
            <%} else {%>
            <a href="getMess.action?currentPage=<%=i%>"><%=i%>
            </a>
            <%
                    }
                }
            %>
        </th>
        <th><a href="getMess.action?currentPage=<%=proPage.getCurrentPage()+1%>"><%="下一页"%>
        </th>
        <th><a href="getMess.action?currentPage=<%=proPage.getPageSize()%>"><%="到底"%>
        </a></th>
    </tr>
    <tr>
        <td colspan="5" align="right">

            <input type="submit" value="批量删除" id="deleAll">

        </td>
    </tr>
</table>

<table id="t3">
    <tr>
        <td>商品Id:</td>
        <td><label>
            <input type="text" disabled value="01">
        </label></td>
    </tr>
    <tr>
        <td>商品图片:</td>
        <td><img src="products/1/c_0001.jpg"></td>
    </tr>
    <tr>
        <td>商品价格:</td>
        <td><label>
            <input type="text" disabled value="345">
        </label></td>
    </tr>
</table>


</body>
</html>
