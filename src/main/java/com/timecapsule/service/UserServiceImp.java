package com.timecapsule.service;

import com.timecapsule.mapper.UserMapper;
import com.timecapsule.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImp implements UserService{

    @Autowired
    UserMapper userMapper;
    @Override
    public User loginValidate(String email, String password) {
        User user = userMapper.findUserByEmailAndPassword(email,password);
        if (user == null){
            return null;
        }else{
            return user;
        }
    }

    @Override
    public int userInsert(String email,String password,String userName) {
        return userMapper.insert(email,password,userName);
    }
}
