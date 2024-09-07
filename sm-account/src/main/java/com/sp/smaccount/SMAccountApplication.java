package com.sp.smaccount;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.sp.common.feign")
@MapperScan("com.sp.smaccount.mapper")
public class SMAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SMAccountApplication.class, args);
    }


    /*
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    */
}