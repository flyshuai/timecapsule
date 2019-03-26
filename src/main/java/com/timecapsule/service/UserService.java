package com.timecapsule.service;


import com.timecapsule.pojo.User;

public interface UserService {
    public User loginValidate(String email,String password);
    public int userInsert(String email,String password,String userName);
//    public String getIdentifyCode(String email);
}
