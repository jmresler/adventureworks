package org.jmresler.spring.aw.services;

import org.jmresler.spring.aw.entities.AppUser;
import org.jmresler.spring.aw.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired protected AppUserRepository userRepository;
	

	/*
	 * TODO - the 'USER' hard coded value needs to be refactored into the AppUser entity
	 */
	@Override
	public UserDetails loadUserByUsername(String userName) {
		AppUser user = userRepository.findByUserName(userName);
		UserDetails userDetails = new User(user.getUserName(), user.getPassword(), true, true, true, true, AuthorityUtils.createAuthorityList("USER"));
		return userDetails;
	}
	
}
