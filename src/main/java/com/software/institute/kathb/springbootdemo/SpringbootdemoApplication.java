package com.software.institute.kathb.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringbootdemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootdemoApplication.class, args);
	}

	@CrossOrigin("http://localhost:3000")
	@GetMapping("/customRoute")
	public String MyResponse()
	{
		Inventory inventory = new Inventory();
		return inventory.toString();
	}

}
