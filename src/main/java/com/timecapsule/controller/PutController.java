package com.timecapsule.controller;

import com.timecapsule.pojo.Capsule;
import com.timecapsule.pojo.User;
import com.timecapsule.service.CapsuleService;
import com.timecapsule.tools.FileTool;
import com.timecapsule.tools.JsonResult;
import com.timecapsule.tools.OpenPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;


@Controller
public class PutController {
    @Autowired
    JsonResult jsonResult;
    @Autowired
    Capsule capsule;
    @Autowired
    CapsuleService capsuleService;

    @RequestMapping("soundCapsulePut")
    @ResponseBody
    public JsonResult soundUpload(HttpServletRequest request) throws IOException {
        //获取保存在session中的用户信息
        User user = (User) request.getSession().getAttribute("user");
        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = mpRequest.getFile("file");
        String path = FileTool.uploadFile(file,user);
        capsule.setCapsulePath(path);
        capsule.setCapsuleName(request.getParameter("capsuleName"));
        capsule.setName(request.getParameter("name"));
        capsule.setEmail(request.getParameter("email"));
        capsule.setUserId(user.getUserId());
        capsule.setCapsuleOpenTime(request.getParameter("openTime"));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//格式都为2019-03-18
        capsule.setCapsuleUploadTime(simpleDateFormat.format(date));
        capsule.setCapsuleTypeId(1);
        capsule.setOpenPassword(OpenPassword.buildOpenPassword());
        System.out.println(capsule.toString());
        if (capsuleService.insertSoundCapsule(capsule)==1){
            jsonResult.setStatus(1);
        }else {
            jsonResult.setStatus(0);
        }
        return jsonResult;
    }


    @RequestMapping("movieCapsulePut")
    @ResponseBody
    public JsonResult movieUpload(HttpServletRequest request) throws IOException {
        //获取保存在session中的用户信息
        User user = (User) request.getSession().getAttribute("user");
        MultipartHttpServletRequest mpRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = mpRequest.getFile("file");
        String path = FileTool.uploadFile(file,user);
        capsule.setCapsulePath(path);
        capsule.setCapsuleName(request.getParameter("capsuleName"));
        capsule.setName(request.getParameter("name"));
        capsule.setEmail(request.getParameter("email"));
        capsule.setUserId(user.getUserId());
        capsule.setCapsuleOpenTime(request.getParameter("openTime"));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//格式都为2019-03-18
        capsule.setCapsuleUploadTime(simpleDateFormat.format(date));
        capsule.setCapsuleTypeId(1);
        capsule.setOpenPassword(OpenPassword.buildOpenPassword());
        System.out.println(capsule.toString());
        if (capsuleService.insertSoundCapsule(capsule)==1){
            jsonResult.setStatus(1);
        }else {
            jsonResult.setStatus(0);
        }
        return jsonResult;
    }


}
