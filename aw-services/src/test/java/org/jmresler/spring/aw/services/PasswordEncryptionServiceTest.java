package org.jmresler.spring.aw.services;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.jmresler.spring.aw.entities.Person;
import org.jmresler.spring.aw.repositories.PersonRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PasswordEncryptionServiceTest {

	@Autowired PersonRepository personRepository;
	
	/**
	 * 
	 */
	@Test
	public void testAuthenticate() {
		final String userName = "jmresler";
		final String password = "password";
		Optional<Person> person = personRepository.findByUserName(userName);
		List<String> salt = new ArrayList<>();
		person.ifPresent(p -> salt.add(p.getPassword().getPasswordSalt()));
		// need to determine the algorithm to take this salt and password and
		// generate the hashed password for comparison
		
	}

	/**
	 * 
	 */
	@Test
	public void testGetEncryptedPassword() {
		
	}

	/**
	 * Just testing to determine algorithm is supported by the underlying JRE
	 * @throws NoSuchAlgorithmException
	 */
	@Test
	public void testGenerateSalt() throws NoSuchAlgorithmException {
	}
}
