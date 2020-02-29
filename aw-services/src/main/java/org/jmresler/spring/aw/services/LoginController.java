/**
 * 
 */
package org.jmresler.spring.aw.services;


import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.jws.WebParam;

import org.jmresler.spring.aw.entities.AppUser;
import org.jmresler.spring.aw.repositories.AppUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John
 *
 */
@RestController(value = "/access")
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired protected AppUserRepository appUserRepository;

	@RequestMapping(value = "/login", method =  {POST, GET})
	public boolean login(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password) {
		boolean success = false;
		appUserRepository.findByUserName(userName);
		logger.info("userName: " + userName + " password: " + password);
		System.err.println("userName: " + userName + " password: " + password);
		return success;
	}

	@RequestMapping(value = "/logout", method = POST)
	public boolean logout(String userName) {
		boolean success = false;
		AppUser user = appUserRepository.findByUserName(userName);
		System.out.println("userName: " + userName + " logged out ");
		return success;
	}

	@RequestMapping(value="/arbitrary", method = GET)
	public Object arbitrary() {
		return new Object();
	}
}
