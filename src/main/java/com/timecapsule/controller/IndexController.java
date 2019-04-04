package com.timecapsule.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @RequestMapping("put")
    public String put(){
        return "put/put";
    }

    @RequestMapping("textPut")
    public String textPut(){
        return "put/textPut";
    }

    @RequestMapping("soundPut")
    public String soundPut(){
        return "put/soundPut";
    }

    @RequestMapping("moviePut")
    public String moviePut(){
        return "put/moviePut";
    }
}
