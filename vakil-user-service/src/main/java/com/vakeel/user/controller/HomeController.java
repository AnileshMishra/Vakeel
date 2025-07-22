package com.vakeel.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vakeel.common_lib.dto.User;


@RestController
@RequestMapping("/registration")
public class HomeController {

	@RequestMapping(value="/hello0", method = RequestMethod.POST)
	public ResponseEntity<String> hello(){
		User user = new User();
		user.setId(0);
		try {
			return ResponseEntity.ok("Hello, Anilesh");
		} catch (Exception e) {
			return ResponseEntity.ofNullable("Exception!!!");
		}
			
	}
}
