package com.psjasecurity.CheckSpringSecurity.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class CustomPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// TODO Auto-generated method stub
		System.out.println( "In custom password encoder matches" );
		return true;
	}

}
