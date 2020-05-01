package org.jmresler.spring.aw.entities;


import static org.junit.Assert.assertTrue;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BusinessEntityTest {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("aw-entities-pu");
    private EntityManager em = emf.createEntityManager();
    private final Random numGen = new Random(System.nanoTime());
    
    @BeforeClass
    private void setup() {
    }

    @AfterClass
    private void tearDown() {
    }
    
    @Test
    public void testBusinessEntityFindAll() {
        Query query = em.createNamedQuery("BusinessEntity.findAll");
        assertTrue(!query.getResultList().isEmpty());
    }
}
