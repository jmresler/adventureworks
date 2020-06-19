package org.jmresler.spring.aw.repositories;

import org.jmresler.spring.aw.entities.Password;
import org.springframework.data.repository.CrudRepository;

public interface PasswordRepository extends CrudRepository<Password, Integer> {

}
