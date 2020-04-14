package org.jmresler.spring.aw.entities;


import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
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

    @BeforeClass
    private void setup() {

    }

    @AfterClass
    private void tearDown() {
    }

    @Test(enabled = false)
    public void testAddressFindAll() {
        Query query = em.createNamedQuery("Address.findAll");
        query.getResultList().forEach(address -> {
            System.out.println(address);
        });

    }

    @Test(enabled = false)
    public void testAddressFindById() {
        Query query = em.createNamedQuery("Address.findByAddressID");
        query.setParameter("addressID", 1);
        query.getResultList().forEach(address -> {
            System.out.println(address);
        });
    }

    @Test(enabled = false)
    public void testfindByAddressLine1() {
        Query query = em.createNamedQuery("Address.findByAddressLine1");
        query.setParameter("addressLine1", "250 Race Court");
        query.getResultList().forEach(address -> {
            System.out.println(address);
        });
    }

    @Test
    public void testAddAddress() {
    	Address address = new Address();
    	address.setAddressLine1("6130 Alma Road");
    	address.setCity("McKinney");
    	address.setPostalCode("75070");
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
    
    @Test
    public void saveAddress() {
        
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
