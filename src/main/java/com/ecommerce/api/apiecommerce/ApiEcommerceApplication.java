package com.ecommerce.api.apiecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ApiEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiEcommerceApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("Batata"));
	}
}
