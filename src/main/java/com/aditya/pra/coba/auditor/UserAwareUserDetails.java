package com.aditya.pra.coba.auditor;

import java.util.Collection;

/*import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;*/

import com.aditya.pra.coba.domain.User;

public class UserAwareUserDetails /*implements UserDetails*/ {

	/*private static final long serialVersionUID = 1L;
	private User user;
	private final Collection<? extends GrantedAuthority> grantedAuthorities;
	
	public UserAwareUserDetails(User user, Collection<? extends GrantedAuthority> grantedAuthorities) {
        this.user = user;
        this.grantedAuthorities = grantedAuthorities;
    }
	
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return grantedAuthorities;
	}

	public String getPassword() {
		return this.user.getPassword();
	}

	public String getUsername() {
		return this.user.getUserName();
	}

	public boolean isAccountNonExpired() {
		return false;
	}

	public boolean isAccountNonLocked() {
		return false;
	}

	public boolean isCredentialsNonExpired() {
		return false;
	}

	public boolean isEnabled() {
		return false;
	}

	public User getUser() {
		return user;
	}*/
}
