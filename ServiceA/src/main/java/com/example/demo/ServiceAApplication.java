package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class ServiceAApplication {

	@Autowired
	Environment environment;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceAApplication.class, args);
	}
	
	@RequestMapping("/servicea")
	public String callServiceA()
	{
		String str = "This is in ServiceA : port : " + environment.getProperty("local.server.port");
		System.out.println(str);
		return str;
	}
	
	@RequestMapping("/serviceab")
	public String callServiceAB()
	{
		String str = callServiceA() + "\n";
		
		RestTemplate resttemplate= new RestTemplate();
		
		str += resttemplate.getForObject("http://localhost:8092/serviceb", String.class);
		
		System.out.println(str);
		
		return str;
	}
}
