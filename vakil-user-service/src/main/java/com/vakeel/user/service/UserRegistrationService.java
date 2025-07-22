package com.vakeel.user.service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vakeel.user.dto.RequestDto;
import com.vakeel.user.dto.ResponseDto;
import com.vakeel.user.model.VmUser;
import com.vakeel.user.repository.JpaVmUserRespsitory;
import com.vakeel.user.service.interfaces.UserRegistrationServiceInterface;
import com.vakeel.user.utils.RegistrationUtils;

@Service
public class UserRegistrationService implements UserRegistrationServiceInterface {

	@Autowired
	private RegistrationUtils registrationUtils;
	@Autowired
	private JpaVmUserRespsitory jpaVmUserRespsitory;

	@Override
	public ResponseDto addNewUser(VmUser vmUser) {
		ResponseDto responseDto = new ResponseDto();
		boolean isExist = registrationUtils.validatedMobileNumber(vmUser);
		if(isExist) {
			responseDto.setStatusCode(401);
			responseDto.setStatusMsg("failed.");
			responseDto.setResponseMsg("Mobile Number already exist!!!");
			return responseDto;
		}
		String userId = registrationUtils.getUserId(vmUser);
		
		vmUser.setCreatedDate(new Timestamp(new Date().getTime()));
		vmUser.setUserId(userId);
		VmUser user = jpaVmUserRespsitory.save(vmUser);

		if (user.getId() != null) {
			responseDto.setStatusCode(200);
			responseDto.setStatusMsg("Success.");
			responseDto.setResponseMsg("Record created successfully!!!.");
			responseDto.setUser(user);
		} else {
			responseDto.setStatusCode(401);
			responseDto.setStatusMsg("failed.");
			responseDto.setResponseMsg("Record failed to create.");
		}
		return responseDto;

	}

	@Override
	public ResponseDto modidyUser(VmUser vmUser) {
		ResponseDto responseDto = new ResponseDto();

		VmUser user = jpaVmUserRespsitory.save(vmUser);

		if (user.getId() != null) {
			responseDto.setStatusCode(200);
			responseDto.setStatusMsg("Success.");
			responseDto.setResponseMsg("Record modified successfully!!!.");
			responseDto.setUser(user);
		} else {
			responseDto.setStatusCode(401);
			responseDto.setStatusMsg("failed.");
			responseDto.setResponseMsg("Record failed to create.");
		}
		return responseDto;
	}

	@Override
	public ResponseDto deleteUser(RequestDto requestDto) {
		ResponseDto responseDto = new ResponseDto();

		Optional<VmUser> vmUser = jpaVmUserRespsitory.findById(requestDto.getUserId());

		VmUser newVmUser = null;
		if (vmUser.isPresent()) {
			newVmUser = new VmUser();
			newVmUser = vmUser.get();
			newVmUser.setDeleted(true);
			newVmUser.setDeletedDate(new Timestamp(new Date().getTime()));

			newVmUser = jpaVmUserRespsitory.save(newVmUser);
		} else {
			responseDto.setStatusCode(401);
			responseDto.setStatusMsg("failed.");
			responseDto.setResponseMsg("No Record exist.");
			return responseDto;
		}
		if (newVmUser.isDeleted()) {
			responseDto.setStatusCode(200);
			responseDto.setStatusMsg("Success.");
			responseDto.setResponseMsg("Record deleted successfully!!!.");
			responseDto.setUser(newVmUser);
		} else {
			responseDto.setStatusCode(401);
			responseDto.setStatusMsg("failed.");
			responseDto.setResponseMsg("Record failed to delete.");
		}
		return responseDto;
	}

}
