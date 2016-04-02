package com.csc.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Controller;

@Controller
@EnableDiscoveryClient //Enables Eureka client
@SpringBootApplication
@EnableCircuitBreaker //Enables Hystrix
public class UsersServApplication {

    public static void main(String[] args) {
        SpringApplication.run(UsersServApplication.class, args);
    }
}
