package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class ServiceBApplication {

	@Autowired
	Environment environment;
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
	}
	
	@RequestMapping("/serviceb")
	public String callServiceB()
	{
		String str = "This is in ServiceB : port : " + environment.getProperty("local.server.port");
		System.out.println(str);
		return str;
	}
}
