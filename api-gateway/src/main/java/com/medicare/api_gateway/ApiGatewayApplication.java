package com.medicare.api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

//	@Bean
//	public WebMvcConfigurer webMvcConfigurer(){
//		return addCorsMappings(registry) ->{
//			registry.addMapping("/**")
//					.allowedMethods("*")
//					.allowedHeaders("*")
//					.allowedOrigins("*");
//		};
//	}
}
