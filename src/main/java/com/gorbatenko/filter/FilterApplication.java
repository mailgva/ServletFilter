package com.gorbatenko.filter;

import org.apache.coyote.AbstractProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FilterApplication {

	public static void main(String[] args) {
		//System.setProperty("org.apache.coyote.USE_CUSTOM_STATUS_MSG_IN_HEADER", "true");
		SpringApplication.run(FilterApplication.class, args);
	}

	@GetMapping("/")
	public String root() {
		return "Hello world!";
	}

}
