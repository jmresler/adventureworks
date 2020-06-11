/**
 * 
 */
package org.jmresler.spring.aw.domain;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author John
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	/**
	 * 
	 */
	public UserDetailsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * TODO - fix the AuthorityUtils.NO_AUTHORITIES parameter
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		return null;
	}

}
