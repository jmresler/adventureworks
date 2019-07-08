/**
 * 
 */
package org.jmresler.spring.aw.config;

import java.util.Collections;

import org.jmresler.spring.aw.entities.AppUser;
import org.jmresler.spring.aw.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
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

	@Autowired protected AppUserRepository userRepository;
	
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
		AppUser appUser = userRepository.findByUserName(userName);
		UserDetails userDetails = new User(userName, appUser.getPassword(), true, true, true, true, AuthorityUtils.NO_AUTHORITIES);
		return userDetails;
	}

}
