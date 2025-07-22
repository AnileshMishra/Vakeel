package com.vakeel.master.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.vakeel.master.dto.ResponseDto;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class AllControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void getStateList() throws JSONException {
		ResponseEntity<ResponseDto> dto = this.restTemplate.getForEntity("/state/getStateMasterList", ResponseDto.class);
		JSONAssert.assertEquals(String.valueOf(200), dto.getBody().getStatusCode().toString(), false);
	}
}
