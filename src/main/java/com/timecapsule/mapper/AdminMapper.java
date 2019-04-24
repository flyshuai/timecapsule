package com.timecapsule.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminMapper {
    List<Map<String,String>> findAdminByIdAndPassword(String userAccount, String password);
}
