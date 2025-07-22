package com.vakeel.master.dto;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.vakeel.master.modal.DistrictMaster;
import com.vakeel.master.modal.StateMaster;

@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class ResponseDto {

	private Integer statusCode;
	private String statusMsg;
	private String responseMsg;
	private StateMaster stateMaster;
	private List<StateMaster> stateMasterList;
	private DistrictMaster districtMaster;
	private List<DistrictMaster> districtMasterList;
	
	
	public Integer getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusMsg() {
		return statusMsg;
	}
	public void setStatusMsg(String statusMsg) {
		this.statusMsg = statusMsg;
	}
	public StateMaster getStateMaster() {
		return stateMaster;
	}
	public void setStateMaster(StateMaster stateMaster) {
		this.stateMaster = stateMaster;
	}
	public List<StateMaster> getStateMasterList() {
		return stateMasterList;
	}
	public void setStateMasterList(List<StateMaster> stateMasterList) {
		this.stateMasterList = stateMasterList;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public DistrictMaster getDistrictMaster() {
		return districtMaster;
	}
	public void setDistrictMaster(DistrictMaster districtMaster) {
		this.districtMaster = districtMaster;
	}
	public List<DistrictMaster> getDistrictMasterList() {
		return districtMasterList;
	}
	public void setDistrictMasterList(List<DistrictMaster> districtMasterList) {
		this.districtMasterList = districtMasterList;
	}
	@Override
	public int hashCode() {
		return Objects.hash(districtMaster, districtMasterList, responseMsg, stateMaster, stateMasterList, statusCode,
				statusMsg);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDto other = (ResponseDto) obj;
		return Objects.equals(districtMaster, other.districtMaster)
				&& Objects.equals(districtMasterList, other.districtMasterList)
				&& Objects.equals(responseMsg, other.responseMsg) && Objects.equals(stateMaster, other.stateMaster)
				&& Objects.equals(stateMasterList, other.stateMasterList)
				&& Objects.equals(statusCode, other.statusCode) && Objects.equals(statusMsg, other.statusMsg);
	}
	
	
}
