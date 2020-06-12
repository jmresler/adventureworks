package org.jmresler.spring.aw.repositories;

import java.util.Optional;

import org.jmresler.spring.aw.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	/**
	 * 
	 * @param bid
	 * @return
	 */
	Optional<Person> findByBusinessEntityID(@Param(value = "businessEntityID") int bid);
	
	/**
	 * 
	 * @param userName
	 * @return
	 */
	Optional<Person> findByUserName(String userName);

}
