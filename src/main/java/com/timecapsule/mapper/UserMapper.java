package com.timecapsule.mapper;

import com.timecapsule.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {
    public int insertUser(User user);

    public User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    public User findUserByEmail(@Param("email") String email);

    public List<User> selectAllUser(String start, String end, String email);

    public Integer selectAllUserCount(String start, String end, String email);

    public Integer delUserByUserId(Integer userId);
}
