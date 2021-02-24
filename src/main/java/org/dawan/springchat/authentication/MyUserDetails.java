package org.dawan.springchat.authentication;

import java.util.Arrays;
import java.util.Collection;


import org.dawan.springchat.entities.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	private Users user;
	
	public MyUserDetails(Users user) {
		this.user = user;
	}
	
	 	@Override
	    public String getPassword() {
	        return user.getPassword();
	    }
	 
	    @Override
	    public String getUsername() {
	        return user.getUsername();
	    }
	    
	    
	    public String getRole() {
	    	return user.getRole();
	    }
	 
	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }
	 
	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }
	 
	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

		@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
			String role ;
			role = user.getRole();
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
			return Arrays.asList(authority);
		}
}
