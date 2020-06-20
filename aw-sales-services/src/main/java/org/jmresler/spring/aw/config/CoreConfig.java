package org.jmresler.spring.aw.config;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@ComponentScan("org.jmresler.spring")
public class CoreConfig extends WebMvcConfigurerAdapter {

	
	@Autowired private ExecutorService executorService;
	
	/**
	 * 
	 */
	public CoreConfig() {}

	/**
	 * 
	 * @return
	 */
	@Bean
	public ExecutorService setupExecutor() {
		final int coreThreads = 4;
		final int maxThreads = 8;
		final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreThreads, maxThreads, 60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
		threadPoolExecutor.allowCoreThreadTimeOut(true);
		return threadPoolExecutor;
	}


}
