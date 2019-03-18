package com.timecapsule.controller;

import com.timecapsule.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PutController {
    @Autowired
    JsonResult jsonResult;
    @RequestMapping("soundCapsulePut")
    public JsonResult soundUpload(){

        return null;
    }
}
