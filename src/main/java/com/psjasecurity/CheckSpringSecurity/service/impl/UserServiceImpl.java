package com.psjasecurity.CheckSpringSecurity.service.impl;

import org.springframework.stereotype.Service;

import com.psjasecurity.CheckSpringSecurity.service.UserService;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService{

	@Override
	public Boolean authenticate( String userName, String password ) {
		
		if ( userName.equals( "PSJA_USERNAME" ) && password.equals( "PSJA_PASSWORD" )  )
			return Boolean.TRUE;
		
		return Boolean.FALSE;
	}
}
