/**
 * 
 */
package org.jmresler.spring.aw.services;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Optional;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;

import org.jmresler.spring.aw.entities.Password;
import org.jmresler.spring.aw.entities.Person;
import org.jmresler.spring.aw.repositories.PersonRepository;
import org.keycloak.KeycloakSecurityContext;
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

	@Autowired
	private PersonRepository repository;
	@Autowired
	private PasswordEncryptionService encryptionService;

	private static final String BAD_PASSWORD = "Bad password";
	private static final String USER_NOT_FOUND = "User not found";

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
	@RequestMapping(value = "/login", method = { POST })
	public String login(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password) {
		log.info("user : " + userName + " attempted login");
		return handleUserLookup(userName, password);
	}

	private String handleUserLookup(String userName, String password) {
		try {
			Optional<Person> optPerson = repository.findByUserName(userName);

			if (optPerson.isPresent()) {
				Person person = optPerson.get();
				Password pPassword = person.getPassword();
				boolean authenticated = encryptionService.authenticate(password, pPassword.getPasswordHash().getBytes(),
						pPassword.getPasswordSalt().getBytes());

				if (authenticated) {
					// return JWTS
				} else {
					// Increment
				}

				return BAD_PASSWORD;
			}
		} catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {

		}

		return USER_NOT_FOUND;
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
	@RequestMapping(value = "/logout", method = { GET })
	public void logout(String userName) {
		// invalidate the JWTS token
		// TODO - should the JWTS token be returned to the UI
		// or should the UI simply get a message
	}

	/**
	 * 
	 * @return
	 */
	private KeycloakSecurityContext getKeycloakSecurityContext() {
		return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
	}
}
