package com.daniel.math.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@RequestMapping(value = "/set1", method = RequestMethod.GET)
	public String set1() {
		return "set1";
	}

	@RequestMapping(value = "/set2", method = RequestMethod.GET)
	public String set2() {
		return "set2";
	}
}

