package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class BusinessEntityTest {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();
	
	// TODO - Fix error in test
	// Something strange happens with this test...
	// When run independently it works fine. When run in batch mode,
	// the reference to result.getPerson().getBusinessEntityID() returns
	// null for the call here. The Person is not returned, thus any references
	// to the fields in that method cause NPE's. The issue is occurring in the
	// JPA libraries as it indicates an error, not a failure.
	@Test
	public void test() {
		TypedQuery<BusinessEntity> beQuery = manager.createNamedQuery("BusinessEntity.findAll", BusinessEntity.class);
		if (beQuery != null && beQuery.getResultList() != null) {
			beQuery.getResultList().forEach(result -> {
				System.out.println("Business Entity ID:        " + result.getBusinessEntityID());
				System.out.println("Person:                    " + result.getPerson());
				System.out.println("Row GUID :                 " + result.getRowguid());
				System.out.println("Modified Date:             " + result.getModifiedDate());
			});
		} else {
			System.err.println("no results returned from BusinessEntity.findAll query");
		}
	}

}
