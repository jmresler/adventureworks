/**
 * 
 */
package org.jmresler.spring.aw.sales.repositories;

import org.jmresler.spring.aw.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author johnm
 *
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {

}
