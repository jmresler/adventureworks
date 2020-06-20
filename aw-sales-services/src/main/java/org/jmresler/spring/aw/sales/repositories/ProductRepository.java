package org.jmresler.aw.sales.repositories;

import java.util.List;

import org.jmresler.spring.aw.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	List<Product> findAll();
	
}
