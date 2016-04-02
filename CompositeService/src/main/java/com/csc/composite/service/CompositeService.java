package com.csc.composite.service;

import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.csc.composite.ServiceIds;
import com.csc.composite.util.UrlBuilder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @author mmackevicius
 *
 */
@EnableHystrix
@RestController
public class CompositeService {

	@Autowired
	@LoadBalanced
	RestTemplate restTemplate;

	@Autowired
	UrlBuilder urlBuilder;

	/**
	 * 
	 * @return
	 */
	@HystrixCommand(commandKey = "getResult", groupKey = "CompositeService", fallbackMethod = "getDefaultResult")
	@RequestMapping("/result/{userId}")
	public String getResult(@PathVariable String userId) {
		try {
			String userServiceUrl = urlBuilder.buildHttpUrl(ServiceIds.UserService, "user", userId);
			String paymentServiceUrl = urlBuilder.buildHttpUrl(ServiceIds.PaymentService, "payment", userId);

			String user = restTemplate.getForObject(userServiceUrl, String.class);
			String payment = restTemplate.getForObject(paymentServiceUrl, String.class);

			JSONObject combined = new JSONObject();
			combined.put("User", new JSONObject(user));
			combined.put("Payment", new JSONObject(payment));
			return combined.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@HystrixCommand
	private String getDefaultResult(String userId) {
		return "error";
	}

	/**
	 * 
	 * @return
	 */
	@HystrixCommand
	@RequestMapping("/payments")
	public String getAllPayments() {
		throw new UnsupportedOperationException("Not implemendted yet");
	}

	/**
	 * 
	 * @return
	 */
	@HystrixCommand
	@RequestMapping("/pay/{productId}")
	public String payForProduct(@PathVariable String productId) {
		throw new UnsupportedOperationException("Not implemendted yet");
	}
}
