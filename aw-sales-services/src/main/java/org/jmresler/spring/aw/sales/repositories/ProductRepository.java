package org.jmresler.spring.aw.sales.repositories;

import org.jmresler.spring.aw.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 
 * @author johnm
 *
 */
public interface ProductRepository extends JpaRepository<Product, Integer>{

}
