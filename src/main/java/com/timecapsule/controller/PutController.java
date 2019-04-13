package com.timecapsule.controller;

import com.timecapsule.pojo.Capsule;
import com.timecapsule.pojo.User;
import com.timecapsule.service.CapsuleService;
import com.timecapsule.tools.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



@Controller
public class PutController {

    private String openPassword = "";
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
        String path = FileTool.uploadFile(file, user);
        capsule.setCapsulePath(path);
        capsule.setCapsuleName(request.getParameter("capsuleName"));
        capsule.setName(request.getParameter("name"));
        capsule.setEmail(request.getParameter("email"));
        capsule.setUserId(user.getUserId());
        capsule.setPutUserName(user.getUserName());
        capsule.setCapsuleOpenTime(request.getParameter("openTime"));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//格式都为2019-03-18
        capsule.setCapsuleUploadTime(simpleDateFormat.format(date));
        capsule.setCapsuleTypeId(2);
        capsule.setOpenPassword(OpenPassword.buildOpenPassword());
        openPassword = capsule.getOpenPassword();
        System.out.println(capsule.toString());
        if (capsuleService.insertSoundCapsule(capsule) == 1) {
            jsonResult.setStatus(1);
        } else {
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
        String path = FileTool.uploadFile(file, user);
        capsule.setCapsulePath(path);
        capsule.setCapsuleName(request.getParameter("capsuleName"));
        capsule.setName(request.getParameter("name"));
        capsule.setEmail(request.getParameter("email"));
        capsule.setUserId(user.getUserId());
        capsule.setPutUserName(user.getUserName());
        capsule.setCapsuleOpenTime(request.getParameter("openTime"));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//格式都为2019-03-18
        capsule.setCapsuleUploadTime(simpleDateFormat.format(date));
        capsule.setCapsuleTypeId(3);
        capsule.setOpenPassword(OpenPassword.buildOpenPassword());
        System.out.println(capsule.toString());
        if (capsuleService.insertSoundCapsule(capsule) == 1) {
            jsonResult.setStatus(1);
        } else {
            jsonResult.setStatus(0);
        }
        return jsonResult;
    }


    @RequestMapping("textCapsulePut")
    @ResponseBody
    public JsonResult textUpload(HttpServletRequest request) throws IOException {
        //获取保存在session中的用户信息
        User user = (User) request.getSession().getAttribute("user");
        capsule.setCapsulePath(request.getParameter("description"));
        capsule.setCapsuleName(request.getParameter("capsuleName"));
        capsule.setName(request.getParameter("name"));
        capsule.setEmail(request.getParameter("email"));
        capsule.setUserId(user.getUserId());
        capsule.setPutUserName(user.getUserName());
        capsule.setCapsuleOpenTime(request.getParameter("openTime"));
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//格式都为2019-03-18
        capsule.setCapsuleUploadTime(simpleDateFormat.format(date));
        capsule.setCapsuleTypeId(1);
        capsule.setOpenPassword(OpenPassword.buildOpenPassword());
        System.out.println(capsule.toString());
        if (capsuleService.insertSoundCapsule(capsule) == 1) {
            jsonResult.setStatus(1);
        } else {
            jsonResult.setStatus(0);
        }
        return jsonResult;
    }


    @PostMapping("/upload_many")
    @ResponseBody
//    @Transactional
    public JsonResult UploadImages(@RequestParam(value = "file", required = false) MultipartFile[] files, MultipartHttpServletRequest request) {
        if (files.length == 0) {
            jsonResult.setMsg("图片为空！");
            return jsonResult;
        } else {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            System.out.println(openPassword);
            String imgUrl = FileUpload.fileMany(files, StaticUtils.SAVE_URL, StaticUtils.FILE_TYPE, user.getUserId());
            int i = capsuleService.insertSoundCapsuleImgs(openPassword, imgUrl);
            return jsonResult;
        }
    }
}
