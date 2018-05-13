package com.daniel.math.services;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daniel.math.services.MathProcessor;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.daniel.math.services.MathProcessorImpl.class)
public class MathProcessorUnitTest {

	@Autowired
	private MathProcessor mathProcessor;
	
	@Test
	public void testAdd() {
		assertThat(mathProcessor.add(1, 2)).isEqualTo(3);
	}
	
	@Test
	public void testSubtract() {
		assertThat(mathProcessor.subtract(11, 3)).isNotEqualTo(8);
	}
}