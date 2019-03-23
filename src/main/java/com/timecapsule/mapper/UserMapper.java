package com.timecapsule.mapper;

import com.timecapsule.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


public interface UserMapper {
    public int insert(@Param("email") String email,@Param("password") String password,@Param("userName")String userName);
    public User findUserByEmailAndPassword(@Param("email") String email,@Param("password") String password);
    public List<Map<String,Object>> find(int id);
}
