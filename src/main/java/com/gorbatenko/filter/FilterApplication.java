package com.gorbatenko.filter;

import org.apache.coyote.AbstractProtocol;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Filter;

@Configuration
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

	@GetMapping("/guard/hello")
	public String guardHello() {
		return "Hello from guard place!";
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		Filter urlGuardFilter = new UrlGuardFilter();
		registration.setFilter(urlGuardFilter);
		registration.addUrlPatterns("/guard/hello");
		return registration;
	}

}
