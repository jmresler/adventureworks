/**
 * 
 */
package org.jmresler.spring.aw.services;



import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

import org.jmresler.spring.aw.entities.AppUser;
import org.jmresler.spring.aw.repositories.AppUserRepository;
import org.keycloak.KeycloakSecurityContext;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

/**
 * @author John
 *
 */
@Slf4j
@RestController
public class LoginController {

	private final HttpServletRequest request;

	/**
	 * 
	 * @param request
	 */
	public LoginController(HttpServletRequest request) {
		this.request = request;
	}

	
	/**
	 * 
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "/login", method =  {POST})
	public String login(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password) {

		return "User Not Found";
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/logout", method = {GET})
	public void logout(String userName) {
		// invalidate the JWTS token
		// TODO - should the JWTS token be returned to the UI
		//	or should the UI simply get a message 
	}

	/**
	 * 
	 * @return
	 */
	private KeycloakSecurityContext getKeycloakSecurityContext() {
		return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
	}

	/**
	 * 
	 * @param password
	 * @param userPassword
	 * @return
	 */
	private boolean passwordMatches(String password, String userPassword) {
		return BCrypt.checkpw(password, userPassword);
	}
}
