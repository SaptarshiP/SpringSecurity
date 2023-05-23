package com.psjasecurity.CheckSpringSecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class CheckSpringSecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckSpringSecurityApplication.class, args);
	}

}
