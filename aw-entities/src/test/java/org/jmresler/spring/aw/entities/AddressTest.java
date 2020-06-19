package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class AddressTest {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();
	
	@Test
	public void test() {
		TypedQuery<Address> addressQuery = manager.createNamedQuery("Address.findAll", Address.class);
		addressQuery.getResultList().forEach(address -> {
			System.out.println("Address ID           : " + address.getAddressID());
			System.out.println("Address Line 1       : " + address.getAddressLine1());
			System.out.println("Address Line 2       : " + address.getAddressLine2());
			System.out.println("City                 : " + address.getCity());
			System.out.println("State or Province ID : " + address.getStateProvinceID());
			System.out.println("Postal code          : " + address.getPostalCode());
			System.out.println();
		});
	}

}
