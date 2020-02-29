/**
 * 
 */
package org.jmresler.spring.aw.repositories;

import org.jmresler.spring.aw.entities.BusinessEntityContact;
import org.jmresler.spring.aw.entities.BusinessEntityContactPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author johnm
 *
 */
public interface BusinessEntityContactRepository extends JpaRepository<BusinessEntityContact, BusinessEntityContactPK> {

}
