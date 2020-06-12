/**
 * 
 */
package org.jmresler.spring.aw.repositories;

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
public class PersonRepositoryTest {

	@Autowired PersonRepository repository;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.jmresler.spring.aw.repositories.PersonRepository#findByBusinessEntityID(int)}.
	 */
	@Test
	public void testFindByBusinessEntityID() {
	}

	/**
	 * Test method for {@link org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Sort)}.
	 */
	@Test
	public void testFindAllSort() {
	}

	@Test
	public void testFindByUserName() {
	}
	
	/**
	 * Test method for {@link org.springframework.data.repository.PagingAndSortingRepository#findAll(org.springframework.data.domain.Pageable)}.
	 */
	@Test
	public void testFindAllPageable() {
	}

}
