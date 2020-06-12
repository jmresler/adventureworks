package org.jmresler.spring.aw.entities;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.Test;

public class PasswordTest {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("aw-entities-pu");
	private EntityManager em = emf.createEntityManager();
	
	@Test
	public void testFindPasswordByBusinessEntityID() {
		Query query = em.createNamedQuery("Password.findByBusinessEntityID");
		query.setParameter("businessEntityID", new Integer(1));
		Password password = (Password) query.getResultList().get(0);
		assertTrue("incorrect password result returned", password.toString().contains("businessEntityID=1"));
	}

}
