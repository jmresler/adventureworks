/**
 * 
 */
package org.jmresler.spring.aw.sales.repositories;

import java.util.Optional;

import org.jmresler.spring.aw.entities.BusinessEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author johnm
 *
 */
public interface BusinessEntityRepository extends JpaRepository<BusinessEntity, Integer>{

	Optional<BusinessEntity> findBusinessEntityByRowguid(String rowguid);
	
}
