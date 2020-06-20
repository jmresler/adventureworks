package org.jmresler.aw.sales.domain;

import java.util.List;

import org.jmresler.aw.sales.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author johnm
 *
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductRepositoryTest {
	
	@Autowired private ProductRepository products;
	
	@Test
	public void testProductRepository_ExpectPass() {
		products.findAll().forEach(product -> {
			log.info(product.toString());
		});
	}
	
}
