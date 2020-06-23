package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class BusinessEntityAddressTest {
	
	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private EntityManager manager = factory.createEntityManager();
	
	@Test
	public void test() {
		TypedQuery<BusinessEntityAddress> beaQuery = manager.createNamedQuery("BusinessEntityAddress.findAll", BusinessEntityAddress.class);
		beaQuery.getResultList().forEach(result -> {
			System.out.println("Address ID:          " + result.getBusinessEntityAddressPK().getAddressID());
			System.out.println("Business Entity ID: " + result.getBusinessEntityAddressPK().getBusinessEntityID());
			System.out.println();
		});
	}

}
