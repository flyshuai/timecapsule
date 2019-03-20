package com.timecapsule.service;

import com.timecapsule.mapper.UserMapper;
import com.timecapsule.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImp implements UserService{

    @Autowired
    UserMapper userMapper;

    @Autowired
	private JavaMailSender mailSender;

    public User loginValidate(String email, String password) {
        User user = userMapper.findUserByEmailAndPassword(email,password);
        if (user == null){
            return null;
        }else{
            return user;
        }
    }

    public int userInsert(String email,String password,String userName) {
        return userMapper.insert(email,password,userName);
    }

	public String getIdentifyCode(String email) {
		String verificationCode = String.valueOf(((int) ((Math.random() * 9001)) + 999));
		SimpleMailMessage message = new SimpleMailMessage();

		message.setFrom("914423648@qq.com");

		message.setTo(email);

		message.setSubject("主题：验证邮件");

		message.setText(verificationCode);
		System.out.println(message.toString());
//		System.out.println("mailSender:" + mailSender.toString());
		mailSender.send(message);
		return verificationCode;
	}
}
