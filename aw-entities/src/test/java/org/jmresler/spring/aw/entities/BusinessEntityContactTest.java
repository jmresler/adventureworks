package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class BusinessEntityContactTest {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();
	
	@Test
	public void test() {
		TypedQuery<BusinessEntityContact> becQuery = manager.createNamedQuery("BusinessEntityContact.findAll", BusinessEntityContact.class);
		becQuery.getResultList().forEach(result -> {
			System.out.println(result);
		});
	}

}
