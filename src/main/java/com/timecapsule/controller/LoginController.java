package com.timecapsule.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	

	@RequestMapping("send_mail")
	@ResponseBody
	public JsonResult<String> sendMail(String email) throws Exception {
		jsonResult.setStatus(1);
		jsonResult.setMsg("success");
		jsonResult.setResultData(userService.sendMail(email));
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
		User user = userService.loginValidate(email, password);
		if (user == null) {
			jsonResult.setStatus(0);
		} else {
			jsonResult.setStatus(1);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
		}
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
}
