package com.timecapsule.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewController {

    @RequestMapping("toExplain")
    public String explain(){
        return "timecapsuleExplain";
    }

    @RequestMapping("toAdminIndex")
    public String toAdminIndex(HttpServletRequest request){
        return "admin/index";
    }

    @RequestMapping("toAdminLogin")
    public String toAdminLogin(){
        return "admin/login";
    }
}
