package com.vakeel.user.service.interfaces;

import com.vakeel.user.dto.RequestDto;
import com.vakeel.user.dto.ResponseDto;
import com.vakeel.user.model.VmUser;

public interface UserRegistrationServiceInterface {

	ResponseDto addNewUser(VmUser vmUser);

	ResponseDto modidyUser(VmUser vmUser);

	ResponseDto deleteUser(RequestDto requestDto);

}
