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
	protected PersonRepository pRepository;
	
	private static final Person p = new Person();
	
	@RequestMapping("/count")
	public Long getPersonCount() {
		return pRepository.count();
	}

	@RequestMapping(path = "/by-bid", method = {RequestMethod.GET})
	public Person getByBusinessID(final @RequestParam(required = true, name = "bid") Integer bid) {
		return pRepository.findByBusinessEntityID(bid).orElse(p);
	}
}
