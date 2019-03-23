//邮箱验证
function testEmail(email) {
    //对电子邮件的验证
    console.log("邮箱验证开始------"+"email:"+email);
    // var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
    var myreg =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    console.log(myreg.test(email.value));
    console.log(email.value);
    if (!myreg.test(email)) {
        return false;
    }else{
        return true;
    }
}