package com.timecapsule.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OpenController {

    @RequestMapping("toOpen")
    public String toOpen(){
        return "open";
    }
    @RequestMapping("toOpenMovie")
    public String toOpenMovie(){
        return "openMovie";
    }

}
