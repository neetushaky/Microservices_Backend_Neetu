package com.neetu.microservices.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
//will force springbean to reload the configuration
//@refreshScope=will trigger the refresh event to reload the config to spring bean

@RefreshScope
@RestController
public class MessageController {
	
	@Value("${spring.boot.message}")
	private String message;
	@GetMapping("message")
	public String message() {
		return message;
	}

}
