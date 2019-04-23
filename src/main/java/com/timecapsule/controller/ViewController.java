package com.timecapsule.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {

    @RequestMapping("toExplain")
    public String explain(){
        return "timecapsuleExplain";
    }

    @RequestMapping("toAdminIndex")
    public String toAdminIndex(){
        return "admin/index";
    }
}
