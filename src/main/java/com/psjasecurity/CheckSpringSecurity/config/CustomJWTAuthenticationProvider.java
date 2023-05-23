package com.psjasecurity.CheckSpringSecurity.config;

import org.springframework.stereotype.Component;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;

@Component
public class CustomJWTAuthenticationProvider implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		System.out.println("Here in jwt authentication provider");
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		
		return BearerTokenAuthenticationToken.class.isAssignableFrom(authentication);
	}

}
