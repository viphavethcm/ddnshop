package com.ddnshop.usersinfoservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableEurekaClient
//@EnableCircuitBreaker
//@EnableHystrixDashboard
@EnableFeignClients("com.ddnshop.usersinfoservice")
public class UsersInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersInfoServiceApplication.class, args);
    }

    @Bean
    public Sampler defaultSampler(){
        return Sampler.ALWAYS_SAMPLE;
    }

}
