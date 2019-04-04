package com.timecapsule.tools;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class EmailTool {
    @Autowired
    public JavaMailSender mailSender;

    public  String getIdentifyCode(String email)  {
        String verificationCode = String.valueOf(((int) ((Math.random() * 9001)) + 999));
        MimeMessage msg = mailSender.createMimeMessage();
        MimeMessageHelper message = null;
        try {
            message = new MimeMessageHelper(msg, true);

            message.setFrom("914423648@qq.com");

            message.setTo(email);

            message.setSubject("主题：验证邮件");
            String content = "<h1>时光胶囊</h1>您的验证码为<h4 style='color:red'>"+verificationCode+"</font>";
            message.setText(content,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(msg);
        return verificationCode;
    }

    public void sendEmailSchedule(Map<String,Object> map) throws MessagingException {
        String email = (String) map.get("email");
        String name = (String) map.get("userNameCapsule");
        String capsuleName = (String) map.get("capsuleName");
        String openPassword = (String) map.get("capsuleOpenPassword");
        String putUserName = (String) map.get("putUserName");
        Date date = (Date) map.get("capsuleUploadTime");

        MimeMessage msg = mailSender.createMimeMessage();
        //创建MimeMessageHelper对象，处理MimeMessage的辅助类
        MimeMessageHelper message = new MimeMessageHelper(msg, true);
        message.setFrom("914423648@qq.com");
        message.setSubject("主题：提醒邮件");
        message.setTo(email);
        String context = "";
        if(name.equals(putUserName)){
            context = "<h1>时光胶囊</h1><h4>用户"+name+"你好，您于"+ map.get("capsuleUploadTime")+"埋下的胶囊"+capsuleName+
                    "现已经可以打开，请凭借密钥<h4 style='color:red'>"+openPassword+"</h4>,前往<a href='localhost:8080/toOpen'>时间胶囊</a>找寻过去。";
        }else{
            context = "<h1>时光胶囊</h1><h4>"+name+"你好，用户"+putUserName+"于"+map.get("capsuleUploadTime")+"为您埋下的胶囊"+capsuleName+
                    "现已经可以打开，请凭借密钥<h4 style='color:red'>"+openPassword+"</h4>,前往<a href='localhost:8080/toOpen'>时间胶囊</a>查看。";
        }
        message.setText(context,true);
        mailSender.send(msg);
    }
}
