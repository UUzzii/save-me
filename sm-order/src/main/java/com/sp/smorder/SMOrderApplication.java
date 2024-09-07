package com.sp.smorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.sp.smorder.mapper")
public class SMOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SMOrderApplication.class, args);
    }

}