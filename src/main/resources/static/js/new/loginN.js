
//登录按钮的事件
$(document).ready(function() {
    $("#loginButton").click(function() {
        var email = $("#exampleInputEmail1").val();
        var password = $("#exampleInputPassword1").val();
        if ( email == "") {
            $("#error").html("请输入邮箱<span class='badge badge-pill badge-warning'>!</span>");
        } else if (!testEmail(email)) {
            $("#error").html("请输入正确的邮箱格式<span class='badge badge-pill badge-warning'>!</span>");
        }else{
            $("#error").html("");
        }
        if ( password == "") {
            $("#error2").html("请输入密码<span class='badge badge-pill badge-warning'>!</span>");
        } else {
            $("#error2").html("");
        }
        if ( email != "" && password != "") {
            var sData = {
                email: email,
                password: password
            };
            console.log("开始登录--------")
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

