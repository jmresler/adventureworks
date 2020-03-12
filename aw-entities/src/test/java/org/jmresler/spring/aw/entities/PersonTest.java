package org.jmresler.spring.aw.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.logging.Logger;

public class PersonTest {

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
    public void testPersonFindAll() {
        ObjectMapper mapper = new ObjectMapper();
        Query query = em.createNamedQuery("Person.findAll");
        query.getResultList().forEach(person -> {
            Person p = (Person) person;
            try {
                String s = mapper.writeValueAsString(p);
                System.out.println(s);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        });

    }

    @Test
    public void testPersonFindByBusinessEntityID() {
        ObjectMapper mapper = new ObjectMapper();
        Query query = em.createNamedQuery("Person.findByBusinessEntityID");
        query.setParameter("businessEntityID", 1);
        query.getResultList().forEach(person -> {
            try {
                System.out.println(mapper.writeValueAsString(person));
            } catch (JsonProcessingException e) {}
        });
    }


}
