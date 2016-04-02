package com.csc.payment.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csc.payment.model.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @author mmackevicius
 *
 */
@RestController
@RefreshScope
public class PaymentService {

	@Value("${configuration.storeName}")	
	private String storeName;

	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/payment/{userId}")
	@HystrixCommand(commandKey = "getPaymentByUserId", groupKey = "Payments")
	public Payment getPayment(@PathVariable String userId) {
		switch (userId) {
		case "1":
			return new Payment("1", "600 Euro for Iphone from: " + getStoreName());
		default:
			throw new RuntimeException("Payment not found by: " + userId);
		}

	}
	
	
	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


}
