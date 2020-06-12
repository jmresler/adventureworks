package org.jmresler.spring.aw.config;


import org.jmresler.spring.aw.services.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired protected UserDetailServiceImpl userDetails;
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authManager) throws Exception {

	}
}
