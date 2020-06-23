package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class SalesOrderDetailTest {
	
	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();

	@Test
	public void test() {
		TypedQuery<SalesOrderDetail> orderQuery = manager.createNamedQuery("SalesOrderDetail.findAll", SalesOrderDetail.class);
		orderQuery.getResultList().forEach(salesOrder -> {
			System.out.println(salesOrder);
			System.out.println();
		});
	}

}
