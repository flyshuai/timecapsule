package com.timecapsule;

import com.timecapsule.mapper.UserMapper;
import com.timecapsule.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimecapsuleApplicationTests {

    @Autowired
    UserMapper userMapper;


    @Autowired
    User user;
    @Test
    public void contextLoads() {
    }
    @Test
    public void test1() throws SQLException, ClassNotFoundException {
        userMapper.insert("93111","w1w1","w1w1");
    }
}
