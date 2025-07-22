package com.vakeel.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(info = @Info(title = "Users API", version = "1.0", description = "Documentation Users API v1.0"))
public class VakilUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VakilUserServiceApplication.class, args);
	}

}
