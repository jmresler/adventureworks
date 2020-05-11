package org.jmresler.aw.sales.repositories;

import org.jmresler.spring.aw.entities.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer>{

}
