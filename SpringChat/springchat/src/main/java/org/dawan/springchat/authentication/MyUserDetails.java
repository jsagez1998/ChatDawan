package org.dawan.springchat.authentication;

import java.util.Arrays;
import java.util.Collection;

import org.dawan.springchat.entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserDetails implements UserDetails {
	
	private User user;
	
	public MyUserDetails(User user) {
		this.user = user;
	}
	
	 	@Override
	    public String getPassword() {
	        return user.getPassword();
	    }
	 
	    @Override
	    public String getUsername() {
	        return user.getName();
	    }
	    
	    
	    public boolean isModo() {
	    	return user.isModo();
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
			if(user.isModo()) {
				role = "MODO";
			}else {
				role = "USER";
			}
			SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role);
			return Arrays.asList(authority);
		}
}
