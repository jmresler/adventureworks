package org.jmresler.aw;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.jmresler.aw.support.RandomStringGenerator;
import org.jmresler.spring.aw.entities.Password;
import org.jmresler.spring.aw.entities.Person;
import org.mindrot.jbcrypt.BCrypt;

public class Main {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
	private static final EntityManager manager = factory.createEntityManager();

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("aw-entities-pu");
		EntityManager manager = factory.createEntityManager();
		manager.setFlushMode(FlushModeType.AUTO);
		TypedQuery<Person> query = manager.createNamedQuery("Person.findAll", Person.class);
		List<Person> people = query.getResultList();
		RandomStringGenerator generator = new RandomStringGenerator();

		for (Person person : people) {
			Password password = person.getPassword();
			String salt = BCrypt.gensalt();
			String plainTextPass = generator.generateRandomString();
			password.setPasswordSalt(salt);
			String hashedPassword = BCrypt.hashpw(plainTextPass, salt);
			System.out.println("Password for Business Entity ID: " + person.getBusinessEntityID() + " is " + plainTextPass);
			password.setPasswordHash(hashedPassword);
			password.setModifiedDate(new Date());
			password.setLoginAttempts(0);
			password.setPreviousPassword1("prev1");
			password.setPreviousPassword2("prev2");
			password.setPreviousPassword3("prev3");
			manager.getTransaction().begin();
			manager.persist(password);
			manager.getTransaction().commit();
		}
	}

}
