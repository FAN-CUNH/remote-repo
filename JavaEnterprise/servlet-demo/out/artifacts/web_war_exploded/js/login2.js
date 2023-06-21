$(function () {
    console.log("进入js文件")
    // 给表单的提交按钮绑定提交事件
    $("form").submit(function () {
        console.log("开始前端校验！")
        if ($("#userId").val().match("[\\w\\W]*[a-zA-Z]+[\\w\\W]") != null) {
            alert("用户名中不能包含字母！")
            // 用户名中包含字母
            return false;
        }

        if ($("#password").val().length !== 6) {
            alert("密码长度必须纯数字6位！")
            // 密码的长度不是6位
            return false;
        }
        console.log("结束前端校验！")
        return true;
    })
})