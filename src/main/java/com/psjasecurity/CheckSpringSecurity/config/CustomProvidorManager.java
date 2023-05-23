package com.psjasecurity.CheckSpringSecurity.config;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.psjasecurity.CheckSpringSecurity.service.impl.CustomUserDetailsService;

import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

//@Component
public class CustomProvidorManager extends ProviderManager{
	
	//@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	@Autowired
	@Qualifier("CUSTOM_USER_DETAILS_SERVICE")
	UserDetailsService userDetailsService;
	
	
	//@Bean
	DaoAuthenticationProvider getDaoAuthenticationService() {
		CustomDaoAuthenticationProvider customDaoAuthenticationProvider = new CustomDaoAuthenticationProvider( new CustomPasswordEncoder() );
		
		customDaoAuthenticationProvider.setUserDetailsService(new CustomUserDetailsService());
		return customDaoAuthenticationProvider;
	}
	
	//private List<AuthenticationProvider> providers = new ArrayList<>(Arrays.asList( getDaoAuthenticationService()  ));
	private List<AuthenticationProvider> providers = new ArrayList<>();
	public CustomProvidorManager( List<AuthenticationProvider> providers ) {
		super( providers );
		this.providers = providers;
	}
	
	@Override
	public List<AuthenticationProvider> getProviders(){
		return this.providers;
	}
}
