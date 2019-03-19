package com.timecapsule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping("put")
    public String put(){
        return "put";
    }

    @RequestMapping("destory")
    public String destorySession(HttpServletRequest request){
        request.getSession().invalidate();
        return "login";
    }
    @RequestMapping("textPut")
    public String textPut(){
        return "textPut";
    }

    @RequestMapping("soundPut")
    public String soundPut(){
        return "soundPut";
    }

    @RequestMapping("moviePut")
    public String moviePut(){
        return "moviePut";
    }
}
