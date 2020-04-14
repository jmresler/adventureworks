package org.jmresler.spring.aw.repositories;

import java.util.List;
import java.util.Optional;

import org.jmresler.spring.aw.entities.BillOfMaterials;
import org.springframework.data.repository.CrudRepository;

public interface BillOfMaterialsRepository extends CrudRepository<BillOfMaterials, Integer>{
	
	Optional<BillOfMaterials> findByBillOfMaterialsID(Integer id);
	
	List<BillOfMaterials> findAllBillOfMaterials();
	
	

}
