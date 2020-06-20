package org.jmresler.spring.aw.entities.views;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class VEmployeeDepartmentHistoryTest {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();

	
	@Test
	public void test() {
		try {
		TypedQuery<VEmployeeDepartmentHistory> historyQuery = 
				manager.createNamedQuery("VEmployeeDepartmentHistory.findAll", VEmployeeDepartmentHistory.class);
		historyQuery.getResultList().forEach(System.out::println);
		} catch (StackOverflowError e) {
			fail("Infinite recursion occurred in toString method");
		}
	}

}