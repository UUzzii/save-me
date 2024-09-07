package com.sp.smstock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.sp.common.feign")
@MapperScan("com.sp.smstock.mapper")
public class SMStockApplication {

    public static void main(String[] args) {
        SpringApplication.run(SMStockApplication.class, args);
    }

}