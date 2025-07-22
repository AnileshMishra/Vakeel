package com.vakeel.master.controller;


import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vakeel.master.dto.RequestDto;
import com.vakeel.master.dto.ResponseDto;
import com.vakeel.master.modal.DistrictMaster;
import com.vakeel.master.serviceImpl.DistrictMasterServiceImpl;

import jakarta.validation.Valid;


@RestController
@RequestMapping(value = "/district")
public class DistrictMasterController {
	
	@Autowired private DistrictMasterServiceImpl districtMasterService;

	@RequestMapping(value = "/getDistrictMasterList", method = RequestMethod.GET)
	public ResponseEntity<ResponseDto> getDistrictMasterList() {
		ResponseDto responseDto = districtMasterService.getDistrictlist();
		if (responseDto.getStatusCode() == 200) {
			return ResponseEntity.ok(responseDto);
		} else {
			return ResponseEntity.ofNullable(responseDto);
		}
	}
	
	@RequestMapping(value = "/getDistrictMasterByStateCode", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> getDistrictMasterByStateCode(@RequestBody RequestDto requestDto) {
		ResponseDto responseDto = districtMasterService.getDistrictByStateMaster(requestDto);
		if (responseDto.getStatusCode() == 200) {
			return ResponseEntity.ok(responseDto);
		} else {
			return ResponseEntity.ofNullable(responseDto);
		}
	}
	
	@RequestMapping(value = "/createDistrictMaster", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> createDistrictMaster(@Valid @RequestBody DistrictMaster stateMaster) {
		ResponseDto responseDto = districtMasterService.createDistrictInDistrictMaster(stateMaster);
		if (responseDto.getStatusCode() == 200) {
			return ResponseEntity.ok(responseDto);
		} else {
			return ResponseEntity.ofNullable(responseDto);
		}

	}

	@RequestMapping(value = "/deleteDistrict", method = RequestMethod.POST)
	public ResponseEntity<ResponseDto> deleteDistrict(@RequestBody RequestDto requestDto) {
		ResponseDto responseDto = districtMasterService.deleteDistrictInDistrictMaster(requestDto);

		if (responseDto.getStatusCode() == 200) {
			return ResponseEntity.ok(responseDto);
		} else {
			return ResponseEntity.ofNullable(responseDto);
		}
	}
}
