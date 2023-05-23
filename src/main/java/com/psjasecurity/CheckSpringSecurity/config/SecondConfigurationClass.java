package com.psjasecurity.CheckSpringSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.psjasecurity.CheckSpringSecurity.service.impl.CustomUserDetailsService;

import org.springframework.context.annotation.Bean;

@Component
public class SecondConfigurationClass {

	//@Bean("CustomAuthenticationProviderBean")
	DaoAuthenticationProvider getDaoAuthenticationService() {
		CustomDaoAuthenticationProvider customDaoAuthenticationProvider = new CustomDaoAuthenticationProvider( new CustomPasswordEncoder() );
		
		
		customDaoAuthenticationProvider.setUserDetailsService(getUserDetailsServer());
		return customDaoAuthenticationProvider;
	}
	
	
	//@Bean
	UserDetailsService getUserDetailsServer() {
		return new CustomUserDetailsService();
	}
}
