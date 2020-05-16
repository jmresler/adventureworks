package org.jmresler.spring.aw.repositories;

import java.util.List;
import java.util.Optional;

import org.jmresler.spring.aw.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @author John
 *
 */
@RepositoryRestResource
public interface AddressRepository extends JpaRepository<Address, Integer> {
	
	List<Address> findByAddressLine1(String addressLine1);
	
	List<Address> findByCity(String city);
	
	List<Address> findByPostalCode(String postalCode);
	
	Optional<Address> findByAddressID(Integer addressID);
	
}
