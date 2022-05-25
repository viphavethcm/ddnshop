package com.ddnshop.usersinfoservice;

import com.ddnshop.usersinfoservice.config.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties(AppProperties.class)
public class UsersInfoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersInfoServiceApplication.class, args);
    }
}
