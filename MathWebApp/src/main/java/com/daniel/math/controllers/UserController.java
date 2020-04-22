package com.daniel.math.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping(value = "/action1", method = RequestMethod.GET)
	public String action1() {
		return "action1";
	}

	@RequestMapping(value = "/action2", method = RequestMethod.GET)
	public String action2() {
		return "action2";
	}
}
