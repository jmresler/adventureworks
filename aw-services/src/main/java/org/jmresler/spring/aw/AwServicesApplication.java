package org.jmresler.spring.aw;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AwServicesApplication {

	private static final Logger logger = LoggerFactory.getLogger(AwServicesApplication.class);
	
	
	public static void main(String[] args) {
		SpringApplication.run(AwServicesApplication.class, args);
		logger.info("application started...");
	}

	@Bean
	protected CommandLineRunner run() {
		return args -> {
		};
	}
	
}
