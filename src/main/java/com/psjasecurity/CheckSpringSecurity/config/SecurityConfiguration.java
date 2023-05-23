package com.psjasecurity.CheckSpringSecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.web.SecurityFilterChain;

import com.psjasecurity.CheckSpringSecurity.service.impl.CustomUserDetailsService;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	
	SecondConfigurationClass secondConfigurationClass;
	CustomJWTAuthenticationProvider customJWTAuthenticationProvider;
	
	@Autowired
	SecurityConfiguration( SecondConfigurationClass secondConfigurationClass, 
											CustomJWTAuthenticationProvider customJWTAuthenticationProvider ){
		this.secondConfigurationClass = secondConfigurationClass;
		this.customJWTAuthenticationProvider = customJWTAuthenticationProvider;
	}
	
	@Bean
	SecurityFilterChain getSecurityFilterChain( HttpSecurity httpSecurity ) throws Exception {
		
		
		
		httpSecurity.authenticationManager(getCustomAuthenticationProvider())
						.authorizeHttpRequests()
						.anyRequest()
						.authenticated()
						.and()
						.httpBasic();
		
		httpSecurity.addFilter( new CustomAbstractAuthenticationProcessingFilter( getCustomAuthenticationProvider() ) );
		return httpSecurity.build();
	}
	
	@Bean
	ProviderManager getCustomAuthenticationProvider() {
		
		
		List<AuthenticationProvider> providers = new ArrayList<>(Arrays.asList( 
																	customJWTAuthenticationProvider,
																	secondConfigurationClass.getDaoAuthenticationService()));
		CustomProvidorManager customProvidorManager = new CustomProvidorManager( providers );
		return customProvidorManager;
	}
	
//	@Bean("CustomAuthenticationProviderBean")
//	DaoAuthenticationProvider getDaoAuthenticationService() {
//		CustomDaoAuthenticationProvider customDaoAuthenticationProvider = new CustomDaoAuthenticationProvider( new CustomPasswordEncoder() );
//		
//		
//		customDaoAuthenticationProvider.setUserDetailsService(new CustomUserDetailsService());
//		return customDaoAuthenticationProvider;
//	}
	
	
	//@Bean
//	AuthenticationManager getAuthenticationManager( HttpSecurity httpSecurity ) throws Exception {
//	
//		AuthenticationManagerBuilder authenticationManagerBuilder = httpSecurity.getSharedObject( 
//																				AuthenticationManagerBuilder.class );
//		
//		//authenticationManagerBuilder.authenticationProvider(customAuthenticationProvider);
//		return authenticationManagerBuilder.build();
//	}
}
