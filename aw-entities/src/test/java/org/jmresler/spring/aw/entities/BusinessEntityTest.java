package org.jmresler.spring.aw.entities;

import java.util.Comparator;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class BusinessEntityTest {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();
	
	// TODO - Fix error in test
	// @Test - this one is failing for an indeterminate reason now. 
	// When the test is run independently it works fine,
	// when it is run as part of the group of all tests for the project, an error is thrown as shown
	// below:
	// [ERROR] Errors: 
	// 	[ERROR]   BusinessEntityTest.test:26->lambda$1:28 NullPointer
	//
	public void test() {
		TypedQuery<BusinessEntity> beQuery = manager.createNamedQuery("BusinessEntity.findAll", BusinessEntity.class);
		if (beQuery != null && beQuery.getResultList() != null) {
			beQuery.getResultList().forEach(result -> {
				System.out.println("Business Entity ID:        " + result.getBusinessEntityID());
				System.out.println("Person Business Entity ID: " + result.getPerson().getBusinessEntityID());
				System.out.println("Row GUID :                 " + result.getRowguid());
				System.out.println("Modified Date:             " + result.getModifiedDate());
			});
		} else {
			System.err.println("no results returned from BusinessEntity.findAll query");
		}
	}

}
