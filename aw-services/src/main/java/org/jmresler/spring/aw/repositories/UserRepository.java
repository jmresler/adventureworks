/**
 * 
 */
package org.jmresler.spring.aw.repositories;

import org.jmresler.spring.aw.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author John
 *
 */
@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {

	AppUser findUserByUserName(String userName);
	
}
