package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class BillOfMaterialsTest {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();
	
	@Test
	public void test() {
		TypedQuery<BillOfMaterials> bomQuery = manager.createNamedQuery("BillOfMaterials.findAll", BillOfMaterials.class);
		bomQuery.getResultList().forEach(result -> {
			System.out.println("BOM Level:             " + result.getBOMLevel());
			System.out.println("BOM ID:                " + result.getBillOfMaterialsID());
			System.out.println("Component ID:          " + result.getComponentID());
			System.out.println("End Date:              " + result.getEndDate());
			System.out.println("Modified Date:         " + result.getModifiedDate());
			System.out.println("Per-assembly Quantity: " + result.getPerAssemblyQty());
			System.out.println("Product Assembly ID:   " + result.getProductAssemblyID());
			System.out.println("Unit Measure Code:     " + result.getUnitMeasureCode());
			System.out.println();
		});
	}

}
