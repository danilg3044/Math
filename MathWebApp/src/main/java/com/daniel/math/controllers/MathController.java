package com.daniel.math.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.daniel.math.services.MathProcessor;

// http://localhost:8081/swagger-ui.html

@RestController
@RequestMapping("/math")
public class MathController {
	@Autowired
	private MathProcessor mathProcessor;
	
	// http://localhost:8081/math/add/{x}/{y}
	@RequestMapping(value = "/add/{x}/{y}", method = RequestMethod.GET)
	public int add(@PathVariable Integer x, @PathVariable Integer y) {
		return mathProcessor.add(x, y);
	}

	@RequestMapping(value = "/subtract/{x}/{y}", method = RequestMethod.DELETE)
	public int subtract(@PathVariable Integer x, @PathVariable Integer y) {
		return mathProcessor.subtract(x, y);
	}

	@RequestMapping(value = "/divide/{x}/{y}", method = RequestMethod.POST)
	public double divide(@PathVariable Integer x, @PathVariable Integer y) {
		return mathProcessor.divide(x, y);
	}

	@RequestMapping(value = "/multiply/{x}/{y}", method = RequestMethod.PUT)
	public int multiply(@PathVariable Integer x, @PathVariable Integer y) {
		return mathProcessor.multiply(x, y);
	}
	
	@RequestMapping(value = "/addinteger/{x}/{y}", method = RequestMethod.PUT)
	public Integer addInteger(@PathVariable Integer x, @PathVariable Integer y) {
		return mathProcessor.Add(x, y);
	}
}
