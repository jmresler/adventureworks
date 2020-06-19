package org.jmresler.aw.support;

import java.util.Date;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.jmresler.spring.aw.entities.Password;
import org.jmresler.spring.aw.entities.Person;
import org.mindrot.jbcrypt.BCrypt;

public class RandomPasswordGenerator {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
		EntityManager manager = factory.createEntityManager();
		manager.setFlushMode(FlushModeType.AUTO);
		Query query = manager.createNamedQuery("Person.findByBusinessEntityID");
		query.setParameter("businessEntityID", 2);
		Person person = (Person) query.getSingleResult();
		RandomStringGenerator generator = new RandomStringGenerator();
		Password password = new Password();
		String salt = BCrypt.gensalt();
		String plainTextPass = generator.generateRandomString();
		password.setBusinessEntityID(2);
		password.setPasswordSalt(salt);
		password.setPasswordHash(BCrypt.hashpw(plainTextPass, salt));
		password.setModifiedDate(new Date());
		password.setLoginAttempts(0);
		password.setRowguid(UUID.randomUUID().toString());
		password.setPreviousPassword1("");
		password.setPreviousPassword2("");
		password.setPreviousPassword3("");
		password.setPerson(person);
		person.setPassword(password);
		manager.getTransaction().begin();
		manager.persist(password);
		manager.getTransaction().commit();
	}

}
