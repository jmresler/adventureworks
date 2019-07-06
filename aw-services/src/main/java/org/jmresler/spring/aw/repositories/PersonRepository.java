package org.jmresler.spring.aw.repositories;

import java.util.List;

import org.jmresler.spring.aw.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	List<Person> findPersonByFirstNameAndLastName(String firstName, String lastName);
	
	
}
