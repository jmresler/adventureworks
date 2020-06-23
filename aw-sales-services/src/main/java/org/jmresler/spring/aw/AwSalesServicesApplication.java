package org.jmresler.spring.aw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AwSalesServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwSalesServicesApplication.class, args);
		log.info("application started...");
	}

}
