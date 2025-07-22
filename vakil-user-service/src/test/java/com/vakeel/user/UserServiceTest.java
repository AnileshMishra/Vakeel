package com.vakeel.user;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceTest {

	@Autowired
	private MockMvc mockMvc;
	
	private void testApi() throws Exception{
		mockMvc.perform(post("/registration/home"));
	}
}
