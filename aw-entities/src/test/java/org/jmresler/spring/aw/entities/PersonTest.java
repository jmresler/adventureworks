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
	public void testPersonFindAll() {
		Query query = em.createNamedQuery("Person.findByBusinessEntityID");
		query.setParameter("businessEntityID", 1);
		query.getResultList().forEach(person -> System.out.println(person));
	}

	@Test
	public void testBuilder() {
	}

	@Test
	public void testGetAddressID() {
	}

	@Test
	public void testGetAddressLine1() {
	}

	@Test
	public void testGetAddressLine2() {
	}

	@Test
	public void testGetCity() {
	}

	@Test
	public void testGetPostalCode() {
	}

	@Test
	public void testGetSpatialLocation() {
	}

	@Test
	public void testGetRowguid() {
	}

	@Test
	public void testGetModifiedDate() {
	}

	@Test
	public void testGetStateProvinceID() {
	}

	@Test
	public void testGetBusinessEntityAddressCollection() {
	}

	@Test
	public void testCanEqual() {
	}

}
