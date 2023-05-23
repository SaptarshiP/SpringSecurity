package com.psjasecurity.CheckSpringSecurity.config;

import java.util.ArrayList;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationProvider;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

import com.psjasecurity.CheckSpringSecurity.service.UserService;

//@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{

	@Autowired
	@Qualifier("UserServiceImpl")
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		
		if ( userService.authenticate(authentication.getPrincipal().toString(), 
												authentication.getCredentials().toString()) )
					return new UsernamePasswordAuthenticationToken(
												authentication.getPrincipal(), authentication.getCredentials(), 
												new ArrayList<>());
		
		else
			throw new BadCredentialsException("USER is not authenticated");
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
