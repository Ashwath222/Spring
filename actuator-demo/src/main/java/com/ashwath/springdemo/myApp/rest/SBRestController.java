package com.ashwath.springdemo.myApp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SBRestController {

	@GetMapping("/")
	public String sayHello() {
		return "Hello World!\n Time on Server is : "+ LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}
	
	@GetMapping("/fortune")
	public String getDailyFortune() {
		return "Today's gonna be a good day!";
	}
}
