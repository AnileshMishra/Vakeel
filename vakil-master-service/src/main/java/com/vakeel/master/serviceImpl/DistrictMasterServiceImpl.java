package com.vakeel.master.serviceImpl;

import com.vakeel.master.dto.RequestDto;
import com.vakeel.master.dto.ResponseDto;
import com.vakeel.master.modal.DistrictMaster;


public interface DistrictMasterServiceImpl {

	ResponseDto getDistrictlist();

	ResponseDto getDistrictByStateMaster(RequestDto requestDto);

	ResponseDto createDistrictInDistrictMaster(DistrictMaster stateMaster);

	ResponseDto deleteDistrictInDistrictMaster(RequestDto requestDto);

	ResponseDto getStateMasterById(RequestDto requestDto);

	
}
