package com.zc.devcommunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.zc.devcommunity.dao")
public class DevCommunityApplication {

    public static void main(String[] args) {
        SpringApplication.run(DevCommunityApplication.class, args);
    }

}
