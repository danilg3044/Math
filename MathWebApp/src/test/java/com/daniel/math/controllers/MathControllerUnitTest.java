package com.daniel.math.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.daniel.math.controllers.MathController;
import com.daniel.math.services.MathProcessor;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerUnitTest {

	@Captor
	ArgumentCaptor<Integer> xCaptor;
	
	@Captor
	ArgumentCaptor<Integer> yCaptor;
	
	@Mock
	private MathProcessor processor;
	
	@Autowired
	@InjectMocks
	MathController controller;
	
	@Before
	public void init() {
	    MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testControllerAddMethod() throws Exception {
		when(processor.Add(10, 5)).thenReturn(15);
		assertEquals(15, controller.addInteger(10, 5).intValue());
		
		verify(processor).Add(xCaptor.capture(), yCaptor.capture());
		assertThat(xCaptor.getValue().intValue()).isEqualTo(10);
		assertThat(yCaptor.getValue().intValue()).isEqualTo(5);
	}
	
	@Test
	public void testControllerSubtractMethod() throws Exception {
		when(processor.add(1, 2)).thenReturn(3);
		when(processor.subtract(3, 2)).thenReturn(1);
		
		assertEquals(3, controller.add(1, 2));
		assertEquals(1, controller.subtract(3, 2));

		verify(processor, atLeast(1)).add(1,2);
		verify(processor, times(1)).subtract(3,2);
	}
}
