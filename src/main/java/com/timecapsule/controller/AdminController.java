package com.timecapsule.controller;

import com.timecapsule.service.AdminService;
import com.timecapsule.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private JsonResult jsonResult;

    @RequestMapping("adminLogin")
    @ResponseBody
    public JsonResult toAdminIndex(HttpServletRequest request){
        jsonResult = adminService.findAdminByIdAndPassword(request);
        if (jsonResult.getStatus() == 1){
            request.getSession().setAttribute("admin",jsonResult.getResultData());
            return jsonResult;
        }else{
            return jsonResult;
        }
    }
}
