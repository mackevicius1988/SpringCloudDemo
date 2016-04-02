package com.csc.user.service;

import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.csc.user.model.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * 
 * @author mmackevicius
 *
 */
@EnableHystrix
@RestController
public class UserService {

	/**
	 * 
	 * @return
	 */
	@HystrixCommand(commandKey = "getUserByUserId", groupKey = "Users")
	@RequestMapping("/user/{userId}")
	public User getUser(@PathVariable String userId) {
		switch (userId) {
		case "1":
			return new User("1", "Mantas");
		default:
			throw new RuntimeException("User not found by id: " + userId);
		}
	}
}
