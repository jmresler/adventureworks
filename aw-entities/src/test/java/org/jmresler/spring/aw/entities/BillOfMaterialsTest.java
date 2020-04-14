package org.jmresler.spring.aw.entities;

import static org.junit.Assert.*;

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
        query.getResultList().forEach(bom -> {
            System.out.println(bom);
        });

	}

	@Test
	public void testGetBillOfMaterialsID() {
	}

	@Test
	public void testSetBillOfMaterialsID() {
	}

	@Test
	public void testGetBOMLevel() {
	}

	@Test
	public void testGetPerAssemblyQty() {
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
