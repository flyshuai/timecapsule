package com.timecapsule.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.timecapsule.tools.EmailTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timecapsule.pojo.User;
import com.timecapsule.service.UserService;
import com.timecapsule.tools.JsonResult;

@Controller
public class LoginController {

	@Autowired
	JsonResult jsonResult;
	@Autowired
	UserService userService;

	@RequestMapping("toLoginN")
	public String loginN(){
		return "new/loginN";
	}

	@RequestMapping("toRegister")
	public String register(){
		return "new/register";
	}

	@Autowired
	public EmailTool emailTool;

	@PostMapping("getIndentifyCode")
	@ResponseBody
	public JsonResult<String> getIdentifyCode(@RequestBody String email) throws Exception {
		System.out.println(email);
		long beginTime = System.currentTimeMillis();
		System.out.println("发送邮件开始------"+beginTime);
//		String identifyCode = userService.getIdentifyCode(email);
		String identifyCode = emailTool.getIdentifyCode(email);
		if(identifyCode !=null){
            jsonResult.setStatus(1);
            jsonResult.setMsg("success");
            jsonResult.setResultData(identifyCode);
        }else{
            jsonResult.setStatus(0);
            jsonResult.setMsg("fail");
        }
		long endTime = System.currentTimeMillis();
		System.out.println("发送邮件结束------"+endTime);
		System.out.println("用时------"+(endTime-beginTime)+"毫秒");
		return jsonResult;
	}

	@RequestMapping("toLogin")
	public String toLogin() {
		return "login";
	}

	@PostMapping("login")
	@ResponseBody
	public JsonResult<Integer> login(@RequestBody Map<String, String> map, HttpServletRequest request) {
		String email = map.get("email");
		String password = map.get("password");
		System.out.println("开始登录验证---------"+email);
		User user = userService.loginValidate(email, password);
		if (user == null) {
			jsonResult.setStatus(0);
		} else {
			jsonResult.setStatus(1);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
		System.out.println("登录验证结束---------"+email);
		return jsonResult;
	}

	@RequestMapping("toIndex")
	public String toIndex() {
		return "index";
	}

	@RequestMapping("register")
	@ResponseBody
	public int register(@RequestBody Map<String, String> map, HttpServletRequest request) {
		String email = map.get("email");
		String password = map.get("password");
		String userName = map.get("name");
		return userService.userInsert(email, password, userName);
	}

	@RequestMapping("loginOut")
	public String logOut(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "new/loginN";
	}
}
