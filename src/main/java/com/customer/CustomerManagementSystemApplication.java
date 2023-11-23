package com.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class CustomerManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementSystemApplication.class, args);
		System.out.println("Application Started!!");
	}

}
