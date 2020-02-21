package org.jmresler.spring.aw.services;

import java.util.logging.Logger;

import org.jmresler.spring.aw.repositories.PersonRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class PersonControllerTest {

	@Autowired
	protected PersonRepository pRepository;
	
	protected static final Logger logger = Logger.getAnonymousLogger();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetIdByValue() {
		System.out.println(pRepository.findByBusinessEntityID(1));
	}

	@Test
	void testCountPeople() {

	}

	@Test
	void testListPeople() {

	}

	@Test
	void testObject() {

	}

	@Test
	void testGetClass() {

	}

	@Test
	void testHashCode() {

	}

	@Test
	void testEquals() {

	}

	@Test
	void testClone() {

	}

	@Test
	void testToString() {

	}

	@Test
	void testNotify() {

	}

	@Test
	void testNotifyAll() {

	}

	@Test
	void testWaitLong() {

	}

	@Test
	void testWaitLongInt() {

	}

	@Test
	void testWait() {

	}

	@Test
	void testFinalize() {

	}

}
