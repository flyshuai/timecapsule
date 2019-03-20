var var_identifyCode = "";//验证码全局变量
$(document).ready(function () {
    $("#register").click(function () {
        $("#registerPage").show();
        $("#loginPage").css('display','none');
    })
    $("#login").click(function () {
        $("#loginPage").show();
        $("#registerPage").css('display','none');
    })
})
//注册按钮的事件
$(document).ready(function () {
    $("#registerButton").click(function () {

        var name = $("#nameR").val();
        var email = $("#exampleInputEmail2").val();
        var password1 = $("#exampleInputPassword2").val();
        var password2 = $("#exampleInputPassword3").val();
        var identifyCode = $("#identifyCode").val();
        var flagIndetify = false;

        if (name == ""){
            $("#error6").text("请输入姓名");

        }else{
            $("#error6").text("");
        }
        if (email == ""){
            $("#error3").text("请输入邮箱");

        }else{
            $("#error3").text("");
        }
        if (password1 == ""){
            $("#error4").text("请输入密码");
        }else{
            $("#error4").text("");
        }
        if (password2 == ""){
            $("#error5").text("请再一次输入密码");

        }else{
            $("#error5").text("");
        }

        if (password1 != password2 && password2 !="" && password1 !=""){
            $("#error5").text("两次输入的密码不一致，请重新输入");
            $("#exampleInputPassword3").val("");
        }
        if (identifyCode == ""){
            $("#error7").text("请先输入验证码");
        }else if(identifyCode != var_identifyCode ){
            $("#error7").text("验证码输入错误请重新输入");
        }else{
            flagIndetify = true;
            $("#error7").text("");
        }
        if (name != "" && email != "" && password1 != "" && password2 != "" && flagIndetify) {
            console.log(name+"-----"+email+"----"+password1+"---"+password2);
            var sData = {
                name:name,
                email:email,
                password:password1
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
                        location.href="/toLogin"
                    }else{
                        $("#error5").text("注册失败，请联系管理员");
                    }
                }
            })
        }
    })
})

var getIndentify = function(){
    var email = $("#exampleInputEmail2").val();
    console.log(email);
    $.ajax({
        url:'/getIndentifyCode',
        type:'post',
        dataType:'json',
        contentType:"application/json",
        data:JSON.stringify(email),
        success:function (result) {
            if (result.status== 1){
                window.alert("验证码发送成功，快去邮箱查看吧!");
                var_identifyCode = result.resultData;
            }
        }
    })
}



$(document).ready(function () {
    $("#getIdentifyCode").click(function () {
        console.log("wwwwwwww");
        getIndentify();
    })
    $("#cleanButton").click(function () {
        console.log("wwwwwwww");
        $("#nameR").val("");
        $("#exampleInputEmail2").val("");
        $("#exampleInputPassword2").val("");
        $("#exampleInputPassword3").val("");
        $("#identifyCode").val("");
    });
})

//登录按钮的事件
$(document).ready(function() {
    $("#loginButton").click(function() {
        var email = $("#exampleInputEmail1").val();
        var password = $("#exampleInputPassword1").val();
        if ( email == "") {
            $("#error").text("请输入邮箱");
        } else {
            $("#error").text("");
        }
        if ( password == "") {
            $("#error2").text("请输入密码");
        } else {
            $("#error2").text("");
        }
        if ( email != "" && password != "") {
            var sData = {
                email: email,
                password: password
            };
            $.ajax({
                url: "/login",
                type: 'post',
                dataType: 'json',
                contentType : "application/json",
                data: JSON.stringify(sData),
                success: function(result) {
                    if (result.status == 1) {
                        location.href = "/toIndex";
                    } else {
                        $("#error2").text("邮箱或密码错误");
                    }
                },
                fail:function () {
                    $("#error2").text("系统连接，请联系管理员");
                }
            });
        }
    });
});

