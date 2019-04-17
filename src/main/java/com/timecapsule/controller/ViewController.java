package com.timecapsule.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("/explain")
    public String explain(){
        return "/explain";
    }
}
