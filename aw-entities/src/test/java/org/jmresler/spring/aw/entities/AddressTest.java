package org.jmresler.spring.aw.entities;


import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddressTest {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("aw-entities-pu");
    private EntityManager em = emf.createEntityManager();
    private final Random numGen = new Random(System.nanoTime());
    
    @BeforeClass
    private void setup() {
    }

    @AfterClass
    private void tearDown() {
    }
    
    @Test(enabled = false)
    public void testAddressFindAll() {
        Query query = em.createNamedQuery("Address.findAll");
        assertTrue(query.getResultList().size() == 19616);

    }

    @Test(enabled = true)
    public void testFindByAddressLine1() {
    	Query q = em.createNamedQuery("Address.findByAddressLine1");
    	q.setParameter("addressLine1", "1970 Napa Ct.");
    	q.getResultList().forEach(result -> {
    		// there are four different cities with the same addressLine1 value
    		// their addressLine2 is always null
    		Address address = (Address)result;
    		assertTrue(address.getAddressLine2() == null);
    	});
    }

    public void testFindByCity() {
    	Query query = em.createNamedQuery("Address.findByCity");
    	query.setParameter("city", "Bothell");
    	assertTrue(query.getResultList().size() == 26);
    }
    
    @Test(enabled = true)
    public void testAddressFindById() {
        Query query = em.createNamedQuery("Address.findByAddressID");
        query.setParameter("addressID", 1);
        query.getResultList().forEach(address -> {
            System.out.println(address);
        });
    }

    @Test(enabled = true)
    public void testfindByAddressLine1() {
        Query query = em.createNamedQuery("Address.findByAddressLine1");
        query.setParameter("addressLine1", "250 Race Court");
        Set<String> cities = new TreeSet<>();
        cities.add("Bothell");
        query.getResultList().forEach(address -> {
            assertTrue(cities.contains(((Address)address).getCity()));
        });
    }

    /*
     * I've already got this address in my database and the attempts to reinsert it
     * are causing an overflow exception
     */
    @Test(enabled = true)
    public void testAddAddress() {
    	Address address = new Address();
    	address.setAddressLine1(numGen.nextInt() + " Alma Road");
    	address.setCity("McKinney");
    	address.setPostalCode("75071");
    	address.setBusinessEntityAddressCollection(Collections.emptyList());
    	address.setModifiedDate(new Date());
    	address.setRowguid(UUID.randomUUID().toString());
    	StateProvince sp = new StateProvince(1);
    	sp.setAddressCollection(Arrays.asList(address));
    	address.setStateProvinceID(sp);
    	em.getTransaction().begin();
    	em.persist(address);
    	em.getTransaction().commit();
    }
    
    @Test(enabled = false)
    public void saveAddress() {
        Query query = em.createNamedQuery("Address.findByAddressLine1");
        query.setParameter("addressLine1", "250 Race Court");
        Address toSave = (Address) query.getSingleResult();
        toSave.setAddressLine1(numGen.nextInt() + "250 Race Court");
        em.getTransaction().begin();
        em.persist(toSave);
        em.getTransaction().commit();
    }
    
    @Test
    public void testBuilder() {
    }

    @Test
    public void testGetAddressID() {
    }

    @Test
    public void testGetAddressLine1() {
    }

    @Test
    public void testGetAddressLine2() {
    }

    @Test
    public void testGetCity() {
    }

    @Test
    public void testGetPostalCode() {
    }

    @Test
    public void testGetSpatialLocation() {
    }

    @Test
    public void testGetRowguid() {
    }

    @Test
    public void testGetModifiedDate() {
    }

    @Test
    public void testGetStateProvinceID() {
    }

    @Test
    public void testGetBusinessEntityAddressCollection() {
    }

    @Test
    public void testCanEqual() {
    }

}
