package com.timecapsule.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
//@Component
public class User {
    int userId;
    String email;
    String userName;
    String password;
    String registerTime;
    String loginTime;
    Integer AccountStatus;

    public User(String email, String userName, String password, String registerTime) {
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.registerTime = registerTime;
    }



}

