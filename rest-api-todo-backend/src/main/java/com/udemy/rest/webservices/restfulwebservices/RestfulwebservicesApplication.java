package com.udemy.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class RestfulwebservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulwebservicesApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer cors(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				WebMvcConfigurer.super.addCorsMappings(registry);
				registry.addMapping("/**")
						.allowedMethods("*")
						.allowedOrigins("http://localhost:3000")
						.allowedHeaders("*")
						.allowCredentials(false)
						.maxAge(-1);
			}
		};
	}

}
