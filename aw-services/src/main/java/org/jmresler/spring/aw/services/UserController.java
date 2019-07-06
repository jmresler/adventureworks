package org.jmresler.spring.aw.services;

import org.jmresler.spring.aw.entities.AppUser;
import org.jmresler.spring.aw.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	@Autowired protected UserRepository userRepository;
	
	@RequestMapping("/user/{userName}")
	public AppUser findUser(String userName) {
		return userRepository.findUserByUserName(userName);
	}
	
	
}
