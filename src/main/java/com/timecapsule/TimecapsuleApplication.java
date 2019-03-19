package com.timecapsule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.timecapsule.mapper")
public class TimecapsuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimecapsuleApplication.class, args);
    }

}
