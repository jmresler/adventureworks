package org.jmresler.spring.aw.repositories;

import org.jmresler.spring.aw.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{

	AppUser findByUserName(String userName);
	
}
