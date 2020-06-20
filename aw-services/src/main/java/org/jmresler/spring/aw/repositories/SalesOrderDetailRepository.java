/**
 * 
 */
package org.jmresler.spring.aw.repositories;

import org.jmresler.spring.aw.entities.SalesOrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author johnm
 *
 */
public interface SalesOrderDetailRepository extends JpaRepository<SalesOrderDetail, Integer>{

}
