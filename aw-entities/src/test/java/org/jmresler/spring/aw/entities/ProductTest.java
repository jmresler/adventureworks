package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class ProductTest {
	
	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();

	@Test
	public void test() {
		TypedQuery<Product> productQuery = manager.createNamedQuery("Product.findAll", Product.class);
		productQuery.getResultList().forEach(result -> {
			System.out.println("Product ID:          " + result.getProductID());
			System.out.println("Days to Manufacture: " + result.getDaysToManufacture());
			System.out.println("Class 1:             " + result.getClass1());
			System.out.println("Color:               " + result.getColor());
			System.out.println("Product Line:        " + result.getProductLine());
			System.out.println("Product Number:      " + result.getProductNumber());
			System.out.println();
		});
	}

}
