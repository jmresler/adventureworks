package org.jmresler.spring.aw.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	
	@Override
	public UserDetails loadUserByUsername(String userName) {
		return null;
	}
	
}
