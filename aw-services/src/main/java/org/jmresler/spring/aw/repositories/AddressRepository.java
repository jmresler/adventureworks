package org.jmresler.spring.aw.repositories;

import java.util.List;

import org.jmresler.spring.aw.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author John
 *
 */
@RepositoryRestResource
public interface AddressRepository extends JpaRepository<Address, Integer> {

	List<Address> findByAddressLine1(@Param("addressLine1") String addressLine1);
	
}
