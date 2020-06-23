package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class AddressTypeTest {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();
	
	@Test
	public void test() {
		TypedQuery<AddressType> addressQuery = manager.createNamedQuery("AddressType.findAll", AddressType.class);
		addressQuery.getResultList().forEach(result -> {
			System.out.println("Address Type ID : " + result.getAddressTypeID());
			System.out.println("Rowguid:          " + result.getRowguid());
			System.out.println("Modified Date:    " + result.getModifiedDate());
			result.getBusinessEntityAddressCollection().forEach(entity -> {
				Address address = entity.getAddress();
				System.out.println("\t\tAddress Line 1:     " + address.getAddressLine1());
				System.out.println("\t\tAddress Line 2:     " + address.getAddressLine2());
				System.out.println("\t\tCity:               " + address.getCity());
				System.out.println("\t\tState\\Province ID: " + address.getStateProvinceID());
				System.out.println("\t\tPostal Code:        " + address.getPostalCode());
				System.out.println("\t\tRowguid:            " + address.getRowguid());
				System.out.println("\t\tModified Date:      " + address.getModifiedDate());
				System.out.println();
			});
			System.out.println();
		});
	}

}
