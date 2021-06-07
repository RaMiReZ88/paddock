package com.kolkhoz.paddock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class PaddockApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaddockApplication.class, args);
	}

}
