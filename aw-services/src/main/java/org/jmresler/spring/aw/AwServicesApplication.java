package org.jmresler.spring.aw;

import org.jmresler.spring.aw.repositories.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AwServicesApplication {

    private static final Logger logger = LoggerFactory.getLogger(AwServicesApplication.class);
    @Autowired
    protected AppUserRepository repository;

    private void listUsers() {
        repository.findAll().forEach(user -> System.out.println(user));
    }
    
    private static void printAppUserRepository() {
        AwServicesApplication app = new AwServicesApplication();
        app.listUsers();
    }
    
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
