package org.jmresler.spring.aw.services;

import org.jmresler.spring.aw.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class RegistrationController {

	@Autowired PersonRepository repository;
	
	
	@PostMapping(path = "/register", consumes = "application/json", produces = "application/json", params = {})
	public boolean register() {
		log.info("entered method register...");
		return true;
	}
	
}
