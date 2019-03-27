var objURL;
$(document).on('change', '#uploadMovie', function () {
    console.log(this.files[0]);

    function getObjectURL(file) {
        var url = null;
        if (window.createObjcectURL != undefined) {
            url = window.createOjcectURL(file);
        } else if (window.URL != undefined) {
            url = window.URL.createObjectURL(file);
        } else if (window.webkitURL != undefined) {
            url = window.webkitURL.createObjectURL(file);
        }
        return url;
    }
    $("#error5").text("");
    objURL = getObjectURL(this.files[0]);
    console.log(objURL);
    var movie = "<video src=" + objURL + " controls='controls' id='show' autoplay='autoplay' height='200px' width='400px'>";
    $("#movie").html(movie);
});

var clean = function () {
    $("#exampleInputName").val("");
    $("#exampleInputNameCapsule").val("");
    $("#exampleInputEmail1").val("");
    $("#date").val("");
    $("#uploadSound").val("");
}
$("#cleanMovie").click(clean);

$("#submitMovie").click(function () {
    var file = $("#uploadMovie").val();
    var name = $("#exampleInputName").val();
    var capsuleName = $("#exampleInputNameCapsule").val();
    var email = $("#exampleInputEmail1").val();
    var date = $("#date").val();
    if (name == "") {
        $("#error1").text("请输入名字");
    } else {
        $("#error1").text("");
    }
    if (capsuleName == "") {
        $("#error2").text("请输入胶囊名");
    } else {
        $("#error2").text("");
    }
    if (email == "") {
        $("#error3").text("请输入接收的邮箱");
    } else {
        $("#error3").text("");
    }
    if (date == "") {
        $("#error4").text("请输入日期");
    } else {
        $("#error4").text("");
    }
    if (file == "") {
        $("#error5").text("请选择视频");
    }else{
        $("#error5").text("");
    }
    if (name!=""&&capsuleName!=""&&email!=""&&date!=""&&file!="") {
        var formData = new FormData($("#soundForm")[0]);//此处id为form表单的id
        $.ajax({
            url: 'movieCapsulePut',
            type: 'post',
            // dataType: 'json',
            contentType: false,
            data: formData,
            processData: false,
            async: false,
            cache: false,
            success: function (result) {
                if (result.status == 1) {
                    window.alert("上传成功！");
                    clean();
                } else {
                    window.alert("上传失败，请联系管理员")
                }
            },
            fail: function () {
                window.alert("上传失败，请联系管理员");
            }
        })
    }
})