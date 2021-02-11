package org.dawan.springchat.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface MyUserDetailsService {
	
	UserDetails loadUserByUsername(String username);

}
