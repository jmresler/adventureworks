package org.jmresler.spring.aw.entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Test;

public class AWBuildVersionTest {

	private final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private final EntityManager manager = factory.createEntityManager();
	
	@Test
	public void test() {
		TypedQuery<AWBuildVersion> versionQuery = manager.createNamedQuery("AWBuildVersion.findAll", AWBuildVersion.class);
		versionQuery.getResultList().forEach(result -> {
			System.out.println("Database Version:      " + result.getDatabaseVersion());
			System.out.println("System Information ID: " + result.getSystemInformationID());
			System.out.println("Modified Date:         " + result.getModifiedDate());
			System.out.println("Version Date:          " + result.getVersionDate());
			System.out.println();
		});
	}

}
