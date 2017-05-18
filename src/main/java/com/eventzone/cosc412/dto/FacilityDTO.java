package com.eventzone.cosc412.dto;

import java.sql.Timestamp;

public class FacilityDTO {
	Long facilityId;
	String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	String facilityName;
	
    String schoolName;

	String schoolAddress;
	
	Long schoolId;
    
    String facilityLocation;
    
    String facilityDescription;
    
    String totalSeatingCapacity;
    
    Long addedBy;

	Timestamp bookedFrom;
    
    Timestamp bookedTo;
    
    Double pricePerHour;
    
    Long updatedByUserInfoId;
    String zipCode;
    public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	Boolean isActiveForRental;
    
    public Boolean getIsActiveForRental() {
		return isActiveForRental;
	}

	public void setIsActiveForRental(Boolean isActiveForRental) {
		this.isActiveForRental = isActiveForRental;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public String getFacilityLocation() {
		return facilityLocation;
	}

	public void setFacilityLocation(String facilityLocation) {
		this.facilityLocation = facilityLocation;
	}

	public String getFacilityDescription() {
		return facilityDescription;
	}

	public void setFacilityDescription(String facilityDescription) {
		this.facilityDescription = facilityDescription;
	}

	public String getTotalSeatingCapacity() {
		return totalSeatingCapacity;
	}

	public void setTotalSeatingCapacity(String totalSeatingCapacity) {
		this.totalSeatingCapacity = totalSeatingCapacity;
	}

	public Timestamp getBookedFrom() {
		return bookedFrom;
	}

	public void setBookedFrom(Timestamp bookedFrom) {
		this.bookedFrom = bookedFrom;
	}

	public Timestamp getBookedTo() {
		return bookedTo;
	}

	public void setBookedTo(Timestamp bookedTo) {
		this.bookedTo = bookedTo;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	
    
    public Long getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(Long addedBy) {
		this.addedBy = addedBy;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public Long getUpdatedByUserInfoId() {
		return updatedByUserInfoId;
	}

	public void setUpdatedByUserInfoId(Long updatedByUserInfoId) {
		this.updatedByUserInfoId = updatedByUserInfoId;
	}

    
}
