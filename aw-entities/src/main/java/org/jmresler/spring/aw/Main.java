package org.jmresler.spring.aw;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jmresler.spring.aw.entities.DatabaseLog;

/**
 *
 * @author John
 */
public class Main {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("aw-entities-pu");
    private static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
    	em.getTransaction().begin();
    	Query query = em.createNamedQuery("DatabaseLog.findAll", DatabaseLog.class);
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
