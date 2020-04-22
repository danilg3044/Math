package com.daniel.math.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class UnsecureController {
	
	@RequestMapping(value = "/op1", method = RequestMethod.GET)
	public String op1() {
		return "op1";
	}

	@RequestMapping(value = "/op2", method = RequestMethod.GET)
	public String op2() {
		return "op2";
	}
}
