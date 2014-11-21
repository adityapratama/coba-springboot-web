package com.aditya.pra.coba.auditor;

import org.springframework.data.domain.AuditorAware;
/*import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;*/

import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<String>{

	/**
	 * Custom Current Auditor
	 * */
	public String getCurrentAuditor() {
		System.out.println("System Auditor ");
		return "System";
	}
	
	/**
	 * Custom Current Auditor with Authentication Spring Security 
	 * */
	/*public User getCurrentAuditor() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		if(authentication == null || !authentication.isAuthenticated()){
			return null;
		}
		
		return ((UserAwareUserDetails) authentication.getPrincipal()).getUser();
	}*/
}
