package com.vakeel.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vakeel.user.model.VmUser;

public interface JpaVmUserRespsitory extends JpaRepository<VmUser, Long> {

	List<VmUser> findAllByMobileNumber(String MobileNumber);
	
}
