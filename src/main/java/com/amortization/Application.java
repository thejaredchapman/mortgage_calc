package com.amortization;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amortization.mortgage.ValueTrackers;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		final Logger log = LoggerFactory.getLogger(Application.class);

		SpringApplication.run(Application.class, args);
		log.info("Code updated");

	};

	@Bean
	CommandLineRunner ValueTracker() {
		return args -> {
			ValueTrackers ValueTracker = new ValueTracker (id, myUser, email, date,interestAtCurrentMonth,principalAtCurrentMonth,totalInterest,totalPrincipal);
			log.info("ValueTracker: " + ValueTracker + "added.");

		};
	}
	
}
