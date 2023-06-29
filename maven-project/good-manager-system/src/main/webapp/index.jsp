<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>展示商品信息页面</title>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script>
        $(function () {
            $.ajax({
                url: "selectProduct.action",
                data: {pid: $("#pid").val(), pname: $("#pname").val()},
                dataType: "json",
                success(result) {
                    console.log(JSON.stringify(result))
                    if (result) {
                        for (let i = 0; i < result.data.length; i++) {
                            $("#t2").append(
                                "<tr>" +
                                "<td>" +
                                "       <label>" +
                                "           <input type=\"checkbox\" class=\"c1\">" +
                                "       </label>" +
                                "   </td>" +
                                "   <td>" + result.data[i].pid + "</td>" +
                                "   <td>" + result.data[i].pname + "</td>" +
                                "   <td>" + result.data[i].marketPrice + "</td>" +
                                "   <td>" + result.data[i].shopPrice + "</td>" +
                                "   <td>" + result.data[i].category.cname + "</td>" +
                                "   <td>" +
                                "   <button type='button' class='deleteProduct' value='" + result.data[i].pid + "'>" + "删除" + "</button> " +
                                "   </td>" +
                                "   <td>" +
                                "   <a href='getProductByPid.action?pid=" + result.data[i].pid + "'>" + "编辑" + "</a> " +
                                "   </td>" +
                                "</tr>");
                        }

                    }
                }
            })

            $("#seleButt").click(function () {
                // 清空页面
                $("#t2").html("<tr> <td> <label for=\"selectAll\"></label> <input type=\"checkbox\" id=\"selectAll\">全选/全不选</td> <td>商品id</td> <td>商品名称</td><td>市场价</td> <td>商场价</td> <td>类别名称</td> <td>操作</td><td>操作</td></tr>");
                $.ajax({
                    url: "selectProduct.action",
                    data: {pid: $("#pid").val(), pname: $("#pname").val()},
                    dataType: "json",
                    success(result) {
                        console.log(JSON.stringify(result))
                        if (result) {
                            for (let i = 0; i < result.data.length; i++) {
                                $("#t2").append(
                                    "<tr>" +
                                    "<td>" +
                                    "       <label>" +
                                    "           <input type=\"checkbox\" class=\"c1\">" +
                                    "       </label>" +
                                    "   </td>" +
                                    "   <td>" + result.data[i].pid + "</td>" +
                                    "   <td>" + result.data[i].pname + "</td>" +
                                    "   <td>" + result.data[i].marketPrice + "</td>" +
                                    "   <td>" + result.data[i].shopPrice + "</td>" +
                                    "   <td>" + result.data[i].category.cname + "</td>" +
                                    "   <td>" +
                                    "   <button type='button' class='deleteProduct' value='" + result.data[i].pid + "'>" + "删除" + "</button> " +
                                    "   </td>" +
                                    "   <td>" +
                                    "   <a href='getProductByPid.action?pid=" + result.data[i].pid + "'>" + "编辑" + "</a> " +
                                    "   </td>" +
                                    "</tr>");
                            }

                        }
                    }
                })
            });

            $(document).on('click', '.deleteProduct', function () {
                console.log($(this).val())
                $.ajax({
                    url: "deleteProduct.action",
                    data: {
                        pid: $(this).val()
                    },
                    dataType: "json",
                    success(result) {
                        if (result) {
                            location.reload();
                        }
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
        <td><a href="getAllCategory.do">添加商品</a></td>
    </tr>
</table>

<table id="t2">
    <tr>
        <td><label for="selectAll"></label><input type="checkbox" id="selectAll">全选/全不选</td>
        <td>商品id</td>
        <td>商品名称</td>
        <td>类别名称</td>
        <td>市场价</td>
        <td>商场价</td>
        <td>操作</td>
        <td>操作</td>
    </tr>
</table>
</body>
</html>
