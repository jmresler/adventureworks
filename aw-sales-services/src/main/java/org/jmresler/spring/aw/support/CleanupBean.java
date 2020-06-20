package org.jmresler.spring.aw.support;

import java.util.concurrent.ExecutorService;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Cleans up Spring resources on shutdown
 * @author John M. Resler
 *
 */
@Slf4j
@Component
public class CleanupBean implements DisposableBean {

	@Autowired private ExecutorService executorService;
	
	public CleanupBean() {}

	@Override
	public void destroy() throws Exception {
		log.info("Started shutdown service");
		executorService.shutdown();
		log.info("Finished shutdown service");
	}

}
