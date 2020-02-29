/**
 * 
 */
package org.jmresler.spring.aw.services;

import org.jmresler.spring.aw.entities.Person;
import org.jmresler.spring.aw.repositories.PersonRepository;
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

	@Autowired
	protected PersonRepository repository;
	
	private static final Person p = new Person();
	
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
}
