package com.daniel.math.controllers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.daniel.math.IntegrationTest;
import com.daniel.math.controllers.MathController;

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
@Category(IntegrationTest.class)
public class MathControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	public void testControllerAddMethod() throws Exception {
		MockHttpServletResponse response = mvc.perform(get("/math/add/1/2").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("3");
	}
	
	@Test
	public void testControllerSubtractMethod() throws Exception {
		MockHttpServletResponse response = mvc.perform(delete("/math/subtract/3/2").accept(MediaType.APPLICATION_JSON)).andReturn().getResponse();
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo("1");
	}
}
