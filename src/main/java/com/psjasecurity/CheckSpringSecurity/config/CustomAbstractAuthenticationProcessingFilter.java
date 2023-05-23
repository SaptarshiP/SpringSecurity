package com.psjasecurity.CheckSpringSecurity.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken;
import org.springframework.security.oauth2.server.resource.web.authentication.BearerTokenAuthenticationFilter;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAbstractAuthenticationProcessingFilter extends BearerTokenAuthenticationFilter{

		
	
	CustomAbstractAuthenticationProcessingFilter( AuthenticationManager authenticationManager ){
		super( authenticationManager );
	}
	
	@Override
	protected void doFilterInternal( HttpServletRequest request, 
										HttpServletResponse response, 
										FilterChain filterChain )  {
		
		System.out.println( "I am in in customAuthenticationProcessingFilter" );
		try {
			
			System.out.println( request.getHeader("Authorization") );
			SecurityContext context = SecurityContextHolder.createEmptyContext();
			Authentication authentication = new BearerTokenAuthenticationToken(request.getHeader("Authorization"));
			authentication.setAuthenticated(true);
			context.setAuthentication(authentication);
			
			SecurityContextHolder.setContext(context);
			filterChain.doFilter( request, response );
			
		} catch(IOException | ServletException | AuthenticationException  exp) {
		
			System.out.println( exp.getMessage() );
		}
			
	}
}
