package org.jmresler.spring.aw.entities;

import static org.junit.Assert.fail;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class PasswordTest implements Closeable {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();
	
	@Test
	public void testRecursionRemoval_ExpectPass() {
		TypedQuery<Password> passwordQuery = manager.createNamedQuery("Password.findAll", Password.class);
		try {
			passwordQuery.getResultList().forEach(password -> {
				System.out.println(password);
			});
			
			
		} catch (StackOverflowError e) {
			fail("Infinite recursion happened");
		}
	}
	
	
	@Override
	public void close() throws IOException {
		manager.close();
		factory.close();
	}
	
}
