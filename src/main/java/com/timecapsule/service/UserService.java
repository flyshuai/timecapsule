package com.timecapsule.service;


import com.timecapsule.pojo.User;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService {
    public User loginValidate(String email, String password);

    public int userInsert(String email, String password, String userName);

    public List<User> selectAllUser(HttpServletRequest request);

    public Integer selectAllUserCount(HttpServletRequest request);

    public Integer delUserByUserId(HttpServletRequest request);
}
