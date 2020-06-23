package org.jmresler.spring.aw.repositories;

import org.jmresler.spring.aw.entities.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Integer> {

}
