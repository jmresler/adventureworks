package org.jmresler.spring.aw.repositories;

import org.jmresler.spring.aw.entities.AWBuildVersion;
import org.springframework.data.repository.CrudRepository;

public interface AwBuildRepository extends CrudRepository<AWBuildVersion, Long> {
	
}
