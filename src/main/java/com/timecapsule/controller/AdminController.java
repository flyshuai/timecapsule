package com.timecapsule.controller;

import com.timecapsule.pojo.LayuiTableResult;
import com.timecapsule.service.AdminService;
import com.timecapsule.service.UserService;
import com.timecapsule.tools.JsonResult;
import com.timecapsule.tools.StaticUtils;
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
    private UserService userService;
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

    @RequestMapping("toUserList")
    @ResponseBody
    public LayuiTableResult toUserList(HttpServletRequest request){
        return new LayuiTableResult("",userService.selectAllUser(request), StaticUtils.successCode,userService.selectAllUserCount(request));
    }

    @RequestMapping("delUserByUserId")
    @ResponseBody
    public LayuiTableResult delUserByUserId(HttpServletRequest request){
        return new LayuiTableResult("","", userService.delUserByUserId(request),0);
    }
}
