package com.timecapsule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
	
	@RequestMapping("hello")
	@ResponseBody
    public String hello(){
        return "hello1";
    }
	
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
