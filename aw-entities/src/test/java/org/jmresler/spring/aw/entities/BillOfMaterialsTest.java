package org.jmresler.spring.aw.entities;

import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BillOfMaterialsTest {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("aw-entities-pu");
    private EntityManager em = emf.createEntityManager();

	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testFindAll() {
        Query query = em.createNamedQuery("BillOfMaterials.findAll");
        int numResults = query.getResultList().size();
        assertTrue(numResults == 2679);
	}

	@Test
	public void testGetBillOfMaterialsID() {
		BillOfMaterials bom = em.find(BillOfMaterials.class, 1);
		assertTrue(bom.toString().contains("[ billOfMaterialsID=1 ]"));
	}

	@Test
	public void testSetBillOfMaterialsID() {
		/*
		 * ID's are auto generated so this method would fail
		 */
	}

	@Test
	public void testGetBOMLevel() {
		Query query = em.createNamedQuery("BillOfMaterials.findByBOMLevel");
		query.setParameter("bOMLevel", 3);
		assertTrue(query.getResultList().size() == 31);
		query.setParameter("bOMLevel", 2);
		assertTrue(query.getResultList().size() == 993);		
		query.setParameter("bOMLevel", 1);
		assertTrue(query.getResultList().size() == 1548);		
		query.setParameter("bOMLevel", 0);
		assertTrue(query.getResultList().size() == 103);		
	}

	@Test
	public void testGetPerAssemblyQty() {
		Query query = em.createNamedQuery("BillOfMaterials.findByPerAssemblyQty");
		query.setParameter("perAssemblyQty", 1);
		query.getResultList().forEach(result -> {
			System.out.println(result);
		});
	}

	@Test
	public void testGetModifiedDate() {
	}

	@Test
	public void testGetProductAssemblyID() {
	}

	@Test
	public void testGetUnitMeasureCode() {
	}

}
