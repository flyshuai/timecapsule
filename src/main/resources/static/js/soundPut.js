var objURL;
var temp;
$(document).on('change', '#uploadSound', function () {
    // console.log(this.files[0]);

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
    var audio = "<audio src=" + objURL + " controls='controls' id='show' autoplay='autoplay'>"
    $("#audio").html(audio);
});

var clean = function () {
    $("#exampleInputName").val("");
    $("#exampleInputNameCapsule").val("");
    $("#exampleInputEmail1").val("");
    $("#date").val("");
    $("#uploadSound").val("");
    $("#audio").html("");
}
$("#clean").click(clean);

$("#submitSound").click(function () {
    var file = $("#uploadSound").val();
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
        $("#error5").text("请选择音频");
    } else {
        $("#error5").text("");
    }
    if (name != "" && capsuleName != "" && email != "" && date != "" && file != "") {
        var formData = new FormData($("#soundForm")[0]);//此处id为form表单的id
        $.ajax({
            url: 'soundCapsulePut',
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
                    temp = result.msg;
                    $('#imgUpload').click();
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
layui.use('upload', function () {
    upload = layui.upload;
    upload.render({
        elem: '#test2'
        , url: '/upload_many'
        , multiple: true
        , data: {
            openPassword: temp
        }
        , bindAction: '#imgUpload'
        , auto: false
        , choose: function (obj) {
            //预读本地文件示例，不支持ie8
            console.log(temp);
            var files = this.files = obj.pushFile(); //将每次选择的文件追加到文件队列
            obj.preview(function (index, file, result) {
                $('#demo2').append('<img src="' + result + '" alt="' + file.name + '" class="layui-upload-img" style="width: 100px;height: 100px">')
            });
        }
        , done: function (res) {
            //上传完毕
        }
    });
})

