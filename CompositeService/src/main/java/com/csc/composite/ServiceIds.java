package com.csc.composite;
/**
 * 
 * @author mmackevicius
 *
 */
public enum ServiceIds {
	UserService("user-service"), 
	PaymentService("payment-service");
	
	private String value;
	
	ServiceIds(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
