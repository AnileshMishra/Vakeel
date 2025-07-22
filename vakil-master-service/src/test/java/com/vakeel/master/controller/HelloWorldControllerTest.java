package com.vakeel.master.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.vakeel.master.modal.StateMaster;

@WebMvcTest(TestController.class)
class HelloWorldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloWorldBasicTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders
				.get("/hello")
				.accept(MediaType.APPLICATION_JSON);
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World!"))
				.andReturn();

 	}

	@Test
	public void getObjectTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders
				.get("/getOBject")
				.accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request)
//				.andExpect(status().isOk())
//				.andExpect(content().json("{\"id\":1,\"stateName\":\"Delhi\",\"stateCode\":\"DL\"}"))
				.andReturn();

	}

}
