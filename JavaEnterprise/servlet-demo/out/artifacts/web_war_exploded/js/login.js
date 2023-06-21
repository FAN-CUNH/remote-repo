$(function () {
    console.log("测试");
    // 表单验证
    $("form").submit(function () {
        // 用户名不能为空
        if ($("#username").val() == null || $("#username").val() ==="") {
            alert("用户名不能为空！")
            return false;
        }

        // 密码不能为空
        if($("#password").val() == null || $("#password").val() === "") {
            alert("密码不能为空！")
            return  false;
        }

        // 性别必填
        if ($("div:eq(2) input:checked").length === 0) {
            alert("性别必须填写！")
            return false;
        }

        // 兴趣爱好不能为空
        if ($("div:eq(3) input:checked").length === 0) {
            alert("兴趣爱好不能为空")
            return false;
        }

        return true;
    })
})