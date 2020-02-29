/**
 * 
 */
package org.jmresler.spring.aw.repositories;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author johnm
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressRepositoryTest {

	@Autowired AddressRepository repository;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.jmresler.spring.aw.repositories.AddressRepository#findByAddressLine1(java.lang.String)}.
	 */
	@Test
	void testFindByAddressLine1() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.jpa.repository.JpaRepository#findAll()}.
	 */
	@Test
	void testFindAll() {
		System.err.println(repository.findById(1).get());
	}

	/**
	 * Test method for {@link org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Sort)}.
	 */
	@Test
	void testFindAllSort() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.jpa.repository.JpaRepository#findAllById(java.lang.Iterable)}.
	 */
	@Test
	void testFindAllByIdIterableOfID() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.jpa.repository.JpaRepository#getOne(java.lang.Object)}.
	 */
	@Test
	void testGetOne() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link org.springframework.data.jpa.repository.JpaRepository#findAll(org.springframework.data.domain.Example)}.
	 */
	@Test
	void testFindAllExampleOfS() {
		fail("Not yet implemented");
	}

}
