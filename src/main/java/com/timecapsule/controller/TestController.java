package com.timecapsule.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    @RequestMapping("/testOpenSound")
    public String openSound(){
        return "open/openSound";
    }
}
