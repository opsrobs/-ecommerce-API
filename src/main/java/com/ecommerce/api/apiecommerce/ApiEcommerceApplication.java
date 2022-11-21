package com.ecommerce.api.apiecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

@SpringBootApplication
public class ApiEcommerceApplication {

	public static void main(String[] args) throws RuntimeException {
		SpringApplication.run(ApiEcommerceApplication.class, args);
		System.err.println("\n\nVai lá jovem. A API está de pé 👌👌👌");
	}
}
