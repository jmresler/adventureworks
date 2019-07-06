package org.jmresler.spring.aw;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author John
 */
public class Main {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("aw-entities-pu");
    private static final EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
    	EntityTransaction transaction = em.getTransaction();
    	transaction.begin();
		Query addressQuery = em.createNamedQuery("Address.findSpatialLocation");
		addressQuery.setFirstResult(20);
		addressQuery.setMaxResults(10);
		addressQuery.getResultList().forEach(result -> {
			System.out.println(result);
		});
		transaction.commit();
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
