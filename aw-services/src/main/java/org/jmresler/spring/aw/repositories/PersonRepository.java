package org.jmresler.spring.aw.repositories;

import org.jmresler.spring.aw.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {

	/**
	 * 
	 * @param bid
	 * @return
	 */
	Person findByBusinessEntityID(int bid);

}
