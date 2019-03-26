package com.timecapsule.controller;


import com.timecapsule.pojo.Capsule;
import com.timecapsule.service.CapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class OpenController {

    @Autowired
    CapsuleService capsuleService;


    @RequestMapping("toOpen")
    public String toOpen(){
        return "open";
    }
    @RequestMapping("toOpenMovie")
    public String toOpenMovie(){
        return "openMovie";
    }
    @RequestMapping("open")
    public String open(String openPassword) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Capsule capsule = capsuleService.findCapsuleByOpenPassword(openPassword, simpleDateFormat.format(date));
        System.out.println(openPassword+"======"+simpleDateFormat.format(date));
        System.out.println(capsule);
        if (capsule != null) {
            int type = (int) capsule.getCapsuleTypeId();
            if (type == 1) {
                return "index";
            }
            if (type == 2) {
                String path = capsule.getCapsulePath();
                System.out.println(path);
                return "openSound";
            }
            if (type == 3) {
                String path = capsule.getCapsulePath();
                System.out.println(path);
                return "openMovie";
            }
        }
        return "index";
    }
}
