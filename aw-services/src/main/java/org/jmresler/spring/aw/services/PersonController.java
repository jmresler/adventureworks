/**
 * 
 */
package org.jmresler.spring.aw.services;

import javax.servlet.http.HttpServletRequest;

import org.jmresler.spring.aw.entities.Person;
import org.jmresler.spring.aw.repositories.PersonRepository;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John
 *
 */
@RestController
@RequestMapping("/person")
public class PersonController {

	private static final Person p = new Person();

	@Autowired
	protected PersonRepository repository;
	private HttpServletRequest request;
	
	/**
	 * 
	 * @param request
	 */
	public PersonController(HttpServletRequest request) {
		this.request = request;
	}
	
	@RequestMapping("/count")
	public Long getPersonCount() {
		return repository.count();
	}

	@RequestMapping("/all-people")
	public Iterable<Person> getAllPeople() {
		return repository.findAll();
	}
	
	@RequestMapping(path = "/by-bid", method = {RequestMethod.GET})
	public Person getByBusinessID(final @RequestParam(required = true, name = "bid") Integer bid) {
		Person person = new Person();
		person.setFirstName("John");
		person.setLastName("Resler");
		person.setBusinessEntityID(1);
		return person;
	}
	
	private KeycloakSecurityContext getKeycloakSecurityContext() {
		return (KeycloakSecurityContext) request.getAttribute(KeycloakSecurityContext.class.getName());
	}
}
