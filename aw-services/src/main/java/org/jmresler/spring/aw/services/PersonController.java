/**
 * 
 */
package org.jmresler.spring.aw.services;

import org.jmresler.spring.aw.entities.Person;
import org.jmresler.spring.aw.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John
 *
 */
@RestController
public class PersonController {

	@Autowired protected PersonRepository pRepository;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/person")
	public Iterable<Person> findAllPeople() {
		return pRepository.findAll();
	}
	
	
	@RequestMapping("/person-count")
	public long countPeople() {
		return pRepository.count();
	}
	
	
}
