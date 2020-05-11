package org.jmresler.aw.sales.services;

import org.jmresler.aw.sales.repositories.ProductRepository;
import org.jmresler.spring.aw.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@Autowired private ProductRepository repository;
	
	
	@RequestMapping("/products")
	public Iterable<Product> getProducts() {
		return repository.findAll();
	}

}
