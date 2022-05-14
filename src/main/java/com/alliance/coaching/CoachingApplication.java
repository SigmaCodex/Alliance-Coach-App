package com.alliance.coaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class CoachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoachingApplication.class, args);
	}

}
