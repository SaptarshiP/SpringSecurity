package com.psjasecurity.CheckSpringSecurity.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class ApplicationController {

	@RequestMapping( value = "/api/data", method = RequestMethod.GET )
	public String getData() {
		return "SUCCESS_PSJA";
	}
	
}
