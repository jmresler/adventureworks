package org.jmresler.spring.aw.services;

import org.jmresler.spring.aw.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired PersonRepository repository;
	
	/**
	 * 
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) {
		return null;
	}
	
}
