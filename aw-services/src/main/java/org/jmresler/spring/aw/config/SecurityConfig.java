package org.jmresler.spring.aw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired protected UserDetailsServiceImpl userDetails;
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authManager) throws Exception {
		authManager.userDetailsService(userDetails).passwordEncoder(new BCryptPasswordEncoder());
	}
}
