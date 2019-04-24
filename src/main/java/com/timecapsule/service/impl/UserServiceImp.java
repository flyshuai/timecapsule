package com.timecapsule.service.impl;

import com.timecapsule.mapper.UserMapper;
import com.timecapsule.pojo.User;
import com.timecapsule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
	private JavaMailSender mailSender;

    public User loginValidate(String email, String password) {
        User user = userMapper.findUserByEmailAndPassword(email,password);
        return user;
    }

    public int userInsert(String email,String password,String userName) {
        if (userMapper.findUserByEmail(email)==null){
            return userMapper.insert(email,password,userName);
        }else {
            return 0;
        }
    }

//	public String getIdentifyCode(String email) {
//		String verificationCode = String.valueOf(((int) ((Math.random() * 9001)) + 999));
//		SimpleMailMessage message = new SimpleMailMessage();
//
//		message.setFrom("914423648@qq.com");
//
//		message.setTo(email);
//
//		message.setSubject("主题：验证邮件");
//
//		message.setText(verificationCode);
//		mailSender.send(message);
//		return verificationCode;
//	}
}
