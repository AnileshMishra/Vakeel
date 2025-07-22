package com.vakeel.master.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vakeel.master.modal.DistrictMaster;
import com.vakeel.master.modal.StateMaster;

public interface JpaDistrictMasterRepository extends JpaRepository<DistrictMaster, Long> {

	List<DistrictMaster> findAllByIsDeleted(boolean isDeleted);
	
	List<DistrictMaster> findByStateCodeAndIsDeleted(String stateCode, boolean isDeleted);

}
