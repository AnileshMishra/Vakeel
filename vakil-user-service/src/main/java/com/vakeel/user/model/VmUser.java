package com.vakeel.user.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="vm_user", schema="users")
public class VmUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="user_id")
    private String userId;

    @Column(name="user_type")
    private String userType;

    @Column(name="first_name")
    private String firstName;

    @Column(name="second_name")
    private String secondName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="gender")
    private String gender;

    @Column(name="address")
    private String address;

    @Column(name="district_code")
    private String districtCode;

    @Column(name="state_code")
    private String stateCode;

    @Column(name="mobile_number")
    private String mobileNumber;

    @Column(name="practicing_court")
    private String practicingCourt;

    @Column(name="lawyer_type")
    private String lawyerType;

    @Column(name="experiance")
    private Integer experiance;

    @Column(name="created_date")
    private Timestamp createdDate;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @Column(name="deleted_date")
    private Timestamp deletedDate;

    @Column(name="deleted_by")
    private Long deletedBy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrictCode() {
		return districtCode;
	}

	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPracticingCourt() {
		return practicingCourt;
	}

	public void setPracticingCourt(String practicingCourt) {
		this.practicingCourt = practicingCourt;
	}

	public String getLawyerType() {
		return lawyerType;
	}

	public void setLawyerType(String lawyerType) {
		this.lawyerType = lawyerType;
	}

	public Integer getExperiance() {
		return experiance;
	}

	public void setExperiance(Integer experiance) {
		this.experiance = experiance;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Timestamp getDeletedDate() {
		return deletedDate;
	}

	public void setDeletedDate(Timestamp deletedDate) {
		this.deletedDate = deletedDate;
	}

	public Long getDeletedBy() {
		return deletedBy;
	}

	public void setDeletedBy(Long deletedBy) {
		this.deletedBy = deletedBy;
	}
    
    
}
