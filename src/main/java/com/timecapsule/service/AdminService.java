package com.timecapsule.service;

import com.timecapsule.tools.JsonResult;

import javax.servlet.http.HttpServletRequest;

public interface AdminService {
    JsonResult<String> findAdminByIdAndPassword(HttpServletRequest request);
}
