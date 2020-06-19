package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class CommonPasswordsTest {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();
	
	@Test
	public void test() {
		TypedQuery<CommonPasswords> passwordsQuery = manager.createNamedQuery("CommonPasswords.findAll", CommonPasswords.class);
		passwordsQuery.getResultList().forEach(result -> {
			System.out.println("Commonly Used Password: " + result.getPassword());
		});
	}

}
