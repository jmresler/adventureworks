package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class ContactTypeTest {
	
	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();
	
	@Test
	public void test() {
		TypedQuery<ContactType> ctQuery = manager.createNamedQuery("ContactType.findAll", ContactType.class);
		ctQuery.getResultList().forEach(result -> {
			System.out.println("Contact Type ID: " + result.getContactTypeID());
			System.out.println("Modified Date: " + result.getModifiedDate());
			System.out.println("Business Entity Contacts: " + result.getBusinessEntityContactCollection());
			System.out.println();
		});
	}

}
