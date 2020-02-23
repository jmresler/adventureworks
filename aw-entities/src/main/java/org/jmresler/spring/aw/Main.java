package org.jmresler.spring.aw;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jmresler.spring.aw.entities.WorkOrderRouting;

/**
 *
 * @author John
 */
public class Main {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("aw-entities-pu");
    private static final EntityManager em = emf.createEntityManager();
    
    // TODO - This is just quick hack testing to confirm any x to x such as many to many,
    // 		  one to many, many to one relationships standup to the queries. The long
    //		  range fix will be to write unit tests to ensure all the named queries work
    public static void main(String[] args) {
    	em.getTransaction().begin();
    	Query query = em.createNamedQuery("WorkOrderRouting.findAll", WorkOrderRouting.class);
    	query.getResultList().forEach(System.out::println);
    	em.getTransaction().commit();
	}
    
    public static void persist(Object object) {
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}
