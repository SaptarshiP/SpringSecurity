package com.psjasecurity.CheckSpringSecurity.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.psjasecurity.CheckSpringSecurity.dto.CustomUserDetails;

@Service("CUSTOM_USER_DETAILS_SERVICE")
public class CustomUserDetailsService implements UserDetailsService {

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println( "In custom user details matches" );
		return new CustomUserDetails("TEST_PSJA_USERNAME", "TEST_PSJA_PASSWORD");
	}
	
}
