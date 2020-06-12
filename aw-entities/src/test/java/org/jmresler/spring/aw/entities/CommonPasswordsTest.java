package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class CommonPasswordsTest {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("aw-entities-pu");
	private EntityManager em = emf.createEntityManager();
	
	@Test
	public void testGetCommonPassword_byPassword() {
		Query query = em.createNamedQuery("CommonPasswords.findAll");
		query.getResultList().forEach(System.out::println);
	}

}
