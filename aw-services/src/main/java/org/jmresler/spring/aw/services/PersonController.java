/**
 * 
 */
package org.jmresler.spring.aw.services;

import java.util.List;

import org.jmresler.spring.aw.entities.Person;
import org.jmresler.spring.aw.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
