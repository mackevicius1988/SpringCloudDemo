package com.csc.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.core.env.Environment;

/**
 * 
 * @author mmackevicius
 *
 */
@EnableCircuitBreaker
@EnableAutoConfiguration
@EnableDiscoveryClient
@SpringBootApplication
public class PaymentServiceMicroApplication {

	@Autowired
	void setEnvironment(Environment e) {
		System.out.println(e.getProperty("configuration.storeName"));
	}

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceMicroApplication.class, args);
	}
}
