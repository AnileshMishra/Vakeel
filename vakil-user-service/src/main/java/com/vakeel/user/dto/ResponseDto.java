package com.vakeel.user.dto;

import com.vakeel.user.model.VmUser;

public class ResponseDto {

	private Integer statusCode;
	private String statusMsg;
	private String responseMsg;
	private VmUser user;
	
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
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	public VmUser getUser() {
		return user;
	}
	public void setUser(VmUser user) {
		this.user = user;
	}
	
	
}
