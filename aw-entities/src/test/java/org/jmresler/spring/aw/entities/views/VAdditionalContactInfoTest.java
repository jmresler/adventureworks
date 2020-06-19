package org.jmresler.spring.aw.entities.views;

import static org.junit.Assert.fail;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class VAdditionalContactInfoTest {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();

	@Test
	public void testFindAll_ConfirmToString_ExpectPass() {
		try {
			TypedQuery<VAdditionalContactInfo> contactInfoQuery = manager
					.createNamedQuery("VAdditionalContactInfo.findAll", VAdditionalContactInfo.class);
			contactInfoQuery.getResultList().forEach(System.out::println);
		} catch (StackOverflowError e) {
			fail("Infinite recursion occurred in toString method");
		}
	}

}
