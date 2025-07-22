package com.vakeel.master.serviceImpl;

import com.vakeel.master.dto.RequestDto;
import com.vakeel.master.dto.ResponseDto;
import com.vakeel.master.modal.StateMaster;

public interface StateMasterServiceImpl {

	ResponseDto getStatelist();

	ResponseDto createStateInStateMaster(StateMaster stateMaster);

	ResponseDto deleteStateInStateMaster(RequestDto requestDto);

	
}
