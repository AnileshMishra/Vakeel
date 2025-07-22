package com.vakeel.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vakeel.user.dto.RequestDto;
import com.vakeel.user.dto.ResponseDto;
import com.vakeel.user.model.VmUser;
import com.vakeel.user.service.interfaces.UserRegistrationServiceInterface;

@RestController
@RequestMapping(value="/registration")
public class UserRegistrationController {

	@Autowired private UserRegistrationServiceInterface registrationService;
	
	@PostMapping("/add")
//	@RequestMapping(value="/add", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> addUser(@RequestBody VmUser vmUser){
		
		ResponseDto responseDto = registrationService.addNewUser(vmUser);
		if (responseDto.getStatusCode() == 200) {
			return ResponseEntity.ok(responseDto);
		} else {
			return ResponseEntity.ofNullable(responseDto);
		}
	}
	
	@RequestMapping(value="/modify", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> modifyUser(@RequestBody VmUser vmUser){
		
		ResponseDto responseDto = registrationService.modidyUser(vmUser);
		if (responseDto.getStatusCode() == 200) {
			return ResponseEntity.ok(responseDto);
		} else {
			return ResponseEntity.ofNullable(responseDto);
		}
	}
	
	@RequestMapping(value="/delete", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> deleteUser(@RequestBody RequestDto requestDto){
		
		ResponseDto responseDto = registrationService.deleteUser(requestDto);
		if (responseDto.getStatusCode() == 200) {
			return ResponseEntity.ok(responseDto);
		} else {
			return ResponseEntity.ofNullable(responseDto);
		}
	}
	
	@RequestMapping(value="/hello", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> hello(){
		
		ResponseDto dto = new ResponseDto();
		dto.setStatusCode(200);
		dto.setResponseMsg("Hello");
		dto.setStatusMsg("Success");
		dto.setUser(null);
		if (dto.getStatusCode() == 200) {
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.ofNullable(dto);
		}
	}
	
}
