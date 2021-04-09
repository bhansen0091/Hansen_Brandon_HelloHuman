package com.hansen.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class HellohumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HellohumanApplication.class, args);
	}
	
	@RequestMapping("")
	public String hello(@RequestParam(value = "name", required = false) String qFirstName,
			@RequestParam(value = "lastName", required = false) String qLastName) {
		if (qFirstName != null && qLastName != null) {
			return "Hello %s %s.".formatted(qFirstName, qLastName);
		} else if (qFirstName != null) {
			return "Hello %s.".formatted(qFirstName);
		}
		return "Hello Human.";
	}

}
