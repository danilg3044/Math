package com.daniel.math;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daniel.math.controllers.MathController;
import com.daniel.math.services.MathProcessor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MathWebAppTests {

	@Autowired
    private MathController controller;

	@Autowired
    private MathProcessor processor;
	
	@Test
	public void contextLoads() {
		// verify that context has been created successfully
		assertThat(controller).isNotNull();
		assertThat(processor).isNotNull(); 
	}
}
