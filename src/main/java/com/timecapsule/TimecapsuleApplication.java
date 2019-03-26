package com.timecapsule;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.timecapsule.mapper")
@EnableScheduling
public class TimecapsuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimecapsuleApplication.class, args);
    }

}
