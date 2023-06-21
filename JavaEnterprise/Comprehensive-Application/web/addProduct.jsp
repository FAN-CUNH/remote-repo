<%--
  Created by IntelliJ IDEA.
  User: 58238
  Date: 2023/6/9
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script src="./js/jquery-1.11.0.min.js"></script>
<script>
    $(function () {
        $.ajax({
            url:"selectCategory.action",
            dataType:"json",
            success:function (result) {
                $.each(result,function (index,item) {
                    $("#cateSeclect").append("<option value="+item.cid+">"+item.cname+"</option>")
                })
            }
        })
        $("#pid").keyup(function () {
            $.ajax({
                url: "getProductByMess.action",
                type: "post",
                data: {pid: $("#pid").val(), pname:""},
                dataType: "json",
                success: function (result) {
                    //将json字符串装换成jsshu
                    console.log(result);
                    if (result.length==0){
                        $("#cidpro").css("color","black");
                        $("#cidpro").html("当前pid不存在，可添加")
                        $("#addInput").prop("disabled",false);
                    }else {
                        $("#cidpro").css("color","red");
                        $("#cidpro").html("当前pid存在,不可添加")
                        $("#addInput").prop("disabled",true);
                    }

                }, error: function (XMLHTTPRequest) {
                    console.log(XMLHTTPRequest.status);
                }
            })
        })

    })

</script>

<body>
<form action="product/addProduct.action" method="post" enctype="multipart/form-data">
    <table>
        <tr><td>pid:</td><td><input type="text" name="pid" id="pid"> <label id="cidpro"></label> </td> </tr>
        <tr><td>pname:</td><td><input type="text" name="pname"> </td></tr>
        <tr><td>shop_price:</td><td><input type="text" name="shop_price"> </td></tr>
        <tr><td>catename:</td><td><select id="cateSeclect" name="selcategory"></select></td></tr>
        <tr><td>pimage:</td><td><input type="file" name="pimage"> </td></tr>
        <tr><td colspan="2"><input type="submit" value="添加商品" id="addInput" ></td></tr>
    </table>
</form>

</body>
</html>
</html>
