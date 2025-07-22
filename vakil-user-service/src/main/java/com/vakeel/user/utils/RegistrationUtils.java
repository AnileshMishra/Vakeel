package com.vakeel.user.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vakeel.user.model.VmUser;
import com.vakeel.user.repository.JpaVmUserRespsitory;

@Component
public class RegistrationUtils {
	
	@Autowired
	private JpaVmUserRespsitory jpaVmUserRespsitory;

	public String getUserId(VmUser vmUser) {
		String userId = vmUser.getFirstName().toUpperCase();
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		userId = userId.concat("-").concat(dateFormat.format(date).replace("-", "").replace(" ", "").replace(":", ""));
		if (vmUser.getUserType().contains("Lowyer")) {
			userId = userId.concat("-L");
		} else {
			userId = userId.concat("-U");
		}

		return userId;

	}

	public boolean validatedMobileNumber(VmUser vmUser) {

		boolean isMobileExist = false;
		
		List<VmUser> user = jpaVmUserRespsitory.findAllByMobileNumber(vmUser.getMobileNumber());
		
		if(user != null && !user.isEmpty()) {
			isMobileExist = true;
		}
		
		return isMobileExist;
	}

}
