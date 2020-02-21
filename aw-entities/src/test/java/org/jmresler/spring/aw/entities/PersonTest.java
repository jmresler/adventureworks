package org.jmresler.spring.aw.entities;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PersonTest {

	
	private static final Logger logger = Logger.getAnonymousLogger();
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("aw-entities-pu");
	private EntityManager em = emf.createEntityManager();

	@BeforeClass
	private void setup() {

	}

	@AfterClass
	private void tearDown() {
	}

	@Test
	void testPersonFindAll() {
		Query query = em.createNamedQuery("Person.findByBusinessEntityID");
		query.setParameter("businessEntityID", 1);
		query.getResultList().forEach(person -> System.out.println(person));
	}

	@Test
	void testBuilder() {
	}

	@Test
	void testGetAddressID() {
	}

	@Test
	void testGetAddressLine1() {
	}

	@Test
	void testGetAddressLine2() {
	}

	@Test
	void testGetCity() {
	}

	@Test
	void testGetPostalCode() {
	}

	@Test
	void testGetSpatialLocation() {
	}

	@Test
	void testGetRowguid() {
	}

	@Test
	void testGetModifiedDate() {
	}

	@Test
	void testGetStateProvinceID() {
	}

	@Test
	void testGetBusinessEntityAddressCollection() {
	}

	@Test
	void testCanEqual() {
	}

}
