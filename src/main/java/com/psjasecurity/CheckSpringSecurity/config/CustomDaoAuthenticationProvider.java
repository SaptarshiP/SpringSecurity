package com.psjasecurity.CheckSpringSecurity.config;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomDaoAuthenticationProvider extends DaoAuthenticationProvider {

		
	private UserDetailsService userDetailsService;
	
	public CustomDaoAuthenticationProvider( PasswordEncoder passwordEncoder ) {
		super( passwordEncoder );
	}
	
	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Override
	protected UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}
	
	
	
}
