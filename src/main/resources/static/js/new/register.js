var var_identifyCode = "";//验证码全局变量
$(document).ready(function () {

    $("#registerButton").click(function () {

        var name = $("#name").val();
        var email = $("#email").val();
        var password = $("#password").val();
        var confirmPassword = $("#confirmPassword").val();
        var identifyCode = $("#identifyCode").val();
        var flagIndetify = false;

        if (name == ""){
            $("#nameError").html("请输入姓名<span class='badge badge-pill badge-warning'>!</span>");
        }else{
            $("#nameError").html("");
        }
        if (email == ""){
            $("#emailError").html("请输入邮箱<span class='badge badge-pill badge-warning'>!</span>");

        }else{
            $("#emailError").html("");
        }
        if (password == ""){
            $("#passwordError").html("请输入密码<span class='badge badge-pill badge-warning'>!</span>");
        }else{
            $("#passwordError").html("");
        }
        if (confirmPassword == ""){
            $("#confirmPasswordError").html("请再一次输入密码<span class='badge badge-pill badge-warning'>!</span>");

        }else{
            $("#confirmPasswordError").html("");
        }

        if (password != confirmPassword && confirmPassword !="" && password !=""){
            $("#confirmPasswordError").html("两次密码输入不一致<span class='badge badge-pill badge-warning'>!</span>");
            $("#confirmPassword").val("");
        }
        if (identifyCode == ""){
            $("#identifyCodeError").text("请先输入验证码");
        }else if(identifyCode != var_identifyCode ){
            $("#identifyCodeError").text("验证码输入错误请重新输入");
        }else{
            flagIndetify = true;
            $("#identifyCodeError").text("");
        }
        if (name != "" && email != "" && password != "" && confirmPassword != "" && flagIndetify) {
            var sData = {
                name:name,
                email:email,
                password:password
            }
            $.ajax({
                url: "/register",
                type: 'post',
                dataType: 'json',
                contentType : "application/json",
                data: JSON.stringify(sData),
                success:function (result) {
                    if (result == 1){
                        window.alert("注册成功，请登录吧！");
                        location.href="/toLoginN"
                    }else{
                        $("#emailError").html("邮箱已经存在，请直接登录<span class='badge badge-pill badge-warning'>!</span>");
                    }
                }
            })
        }
    })
})

var getIndentify = function(){
    var email = $("#email").val();
    var flag = testEmail(email);
    if (flag) {
        $.ajax({
            async:true,
            url:'/getIndentifyCode',
            type:'post',
            dataType:'json',
            contentType:"application/json",
            data:JSON.stringify(email),
            success:function (result) {
                if (result.status== 1){
                    var_identifyCode = result.resultData;
                }
            }
        })
        window.alert("验证码发送成功，快去邮箱查看吧!");
    }else {
        $("#emailError").html("请输入正确的邮箱格式<span class='badge badge-pill badge-warning'>!</span>");
    }
}

$(document).ready(function () {
    $("#getIdentifyCode").click(function () {
        getIndentify();
    })
    // $("#cleanButton").click(function () {
    //     console.log("清空按钮");
    //     $("#name").val("");
    //     $("#email").val("");
    //     $("#password").val("");
    //     $("#confirmPassword").val("");
    //     $("#identifyCode").val("");
    // });
})
