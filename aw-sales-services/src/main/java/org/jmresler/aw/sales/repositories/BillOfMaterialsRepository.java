package org.jmresler.aw.sales.repositories;

import java.util.Optional;

import org.jmresler.spring.aw.entities.BillOfMaterials;
import org.springframework.data.repository.CrudRepository;

public interface BillOfMaterialsRepository extends CrudRepository<BillOfMaterials, Integer> {

    Optional<BillOfMaterials> findByBillOfMaterialsID(Integer billOfMaterialsID);

}
