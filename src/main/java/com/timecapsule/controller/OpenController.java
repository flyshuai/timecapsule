package com.timecapsule.controller;


import com.timecapsule.pojo.Capsule;
import com.timecapsule.service.CapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
    public String open(String openPassword, HttpServletRequest request) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Capsule capsule = capsuleService.findCapsuleByOpenPassword(openPassword, simpleDateFormat.format(date));
        HttpSession session = request.getSession();
        if (capsule != null) {
            String path = capsule.getCapsulePath();
            int type = (int) capsule.getCapsuleTypeId();
            if (type == 1) {
                session.setAttribute("content",path);
                return "openText";
            }
            if (type == 2) {
                String [] str = capsule.getCapsulePath().split("static");
                System.out.println(str[0]+"=="+str[1]);
                session.setAttribute("path",str[1]);
                return "openSound";
            }
            if (type == 3) {
                String [] str = capsule.getCapsulePath().split("static");
                System.out.println(str[0]+"=="+str[1]);
                session.setAttribute("path",str[1]);
                return "openMovie";
            }
        }
        return "index";
    }
}
