package com.timecapsule.service.impl;

import com.timecapsule.mapper.UserMapper;
import com.timecapsule.pojo.User;
import com.timecapsule.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("UserService")
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    private JavaMailSender mailSender;

    public User loginValidate(String email, String password) {
        User user = userMapper.findUserByEmailAndPassword(email, password);
        return user;
    }

    public int userInsert(String email, String password, String userName) {
        if (userMapper.findUserByEmail(email) == null) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//格式都为2019-03-18
            User user = new User(email, userName, password, simpleDateFormat.format(date));
            return userMapper.insertUser(user);
        } else {
            return 0;
        }
    }

    @Override
    public List<User> selectAllUser(HttpServletRequest request) {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String email = request.getParameter("email");
        return userMapper.selectAllUser(start,end,email);
    }

    @Override
    public Integer selectAllUserCount(HttpServletRequest request) {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String email = request.getParameter("email");
        return userMapper.selectAllUserCount(start,end,email);
    }

    @Override
    public Integer delUserByUserId(HttpServletRequest request) {
//        if (userMapper.delUserByUserId(Integer.valueOf(request.getParameter("userId"))) != 0){
//
//        }
        return userMapper.delUserByUserId(Integer.valueOf(request.getParameter("userId")));
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
