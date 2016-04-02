package com.csc.composite.util;

import org.springframework.stereotype.Component;

import com.csc.composite.ServiceIds;

/**
 * 
 * @author mmackevicius
 *
 */
@Component
public class UrlBuilder {

	private static final String HTTP_PREFIX = "http://";

	/**
	 * 
	 * @param type
	 * @return
	 */
	public String buildHttpUrl(ServiceIds type, String method, Object... args) {
		String httpUrl = HTTP_PREFIX + type.getValue() + "/" + method;

		for (Object arg : args) {
			httpUrl += "/" + arg;
		}
		return httpUrl;
	}

}
