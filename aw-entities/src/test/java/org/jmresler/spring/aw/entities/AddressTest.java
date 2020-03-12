package org.jmresler.spring.aw.entities;

import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddressTest {

    private static final Logger logger = Logger.getAnonymousLogger();
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

    @Test
    public void testAddressFindById() {
        Query query = em.createNamedQuery("Address.findByAddressID");
        query.setParameter("addressID", 1);
        query.getResultList().forEach(address -> {
            System.out.println(address);
        });
    }

    @Test
    public void testfindByAddressLine1() {
        Query query = em.createNamedQuery("Address.findByAddressLine1");
        query.setParameter("addressLine1", "250 Race Court");
        query.getResultList().forEach(address -> {
            System.out.println(address);
        });
    }

    @Test
    public void testAddAddress() {

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
