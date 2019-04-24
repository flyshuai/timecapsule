package com.timecapsule.service.impl;

import com.timecapsule.mapper.AdminMapper;
import com.timecapsule.service.AdminService;
import com.timecapsule.tools.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Service("AdminService")
public class AdminServiceImp implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private JsonResult<Object> jsonResult;

    @Override
    public JsonResult<String> findAdminByIdAndPassword(HttpServletRequest request) {
        String userAccount = request.getParameter("userAccount");
        String password = request.getParameter("password");
        List<Map<String, String>> list = adminMapper.findAdminByIdAndPassword(userAccount, password);
        if (adminMapper.findAdminByIdAndPassword(userAccount, password).size() == 0) {
            return new JsonResult<String>(0, "失败", null);
        } else {
            return new JsonResult<String>(1, "成功", list.get(0).get("adminName"));
        }
    }
}
