package com.eventzone.cosc412.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "Facility")
public class Facility {

	@Id
    @GeneratedValue
	@Column(name = "FACILITY_ID")
	Long facilityId;
	
    @Column(name = "SCHOOL_ID")
    Long schoolId;
    
    @Column(name = "FACILITY_NAME")
    String facilityName;
    
    @Column(name = "FACILITY_LOCATION")
    String facilityLocation;
    
    @Column(name = "FACILITY_DESCRIPTION")
    String facilityDesciption;
    
    @Column(name = "TOTAL_SEATING_CAPACITY")
    String totalSeatingCapacity;
    
    @Column(name = "BOOKED_FROM")
    Timestamp bookedFrom;
    
	@Column(name = "BOOKED_TO")
    Timestamp bookedTo;
    
    @Column(name = "IS_ACTIVE_FOR_RENTAL")
    Boolean isActiveForRental;
    
    @Column(name = "PRICE_PER_HOUR")
    Double pricePerHour;

    @Column(name = "ADDED_BY_USER_INFO_ID")
    Long addedByUserInfoId;
    
    @Column(name = "UPDATED_BY_USER_INFO_ID")
    Long updatedByUserInfoId;
    
    @Column(name = "ZIP_CODE")
    String zipCode;
    
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Long getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(Long facilityId) {
		this.facilityId = facilityId;
	}

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getFacilityLocation() {
		return facilityLocation;
	}

	public void setFacilityLocation(String facilityLocation) {
		this.facilityLocation = facilityLocation;
	}

	public String getFacilityDesciption() {
		return facilityDesciption;
	}

	public void setFacilityDesciption(String facilityDesciption) {
		this.facilityDesciption = facilityDesciption;
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

	public Boolean getIsActiveForRental() {
		return isActiveForRental;
	}

	public void setIsActiveForRental(Boolean isActiveForRental) {
		this.isActiveForRental = isActiveForRental;
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

	public Long getAddedByUserInfoId() {
		return addedByUserInfoId;
	}

	public void setAddedByUserInfoId(Long addedByUserInfoId) {
		this.addedByUserInfoId = addedByUserInfoId;
	}

	public Long getUpdatedByUserInfoId() {
		return updatedByUserInfoId;
	}

	public void setUpdatedByUserInfoId(Long updatedByUserInfoId) {
		this.updatedByUserInfoId = updatedByUserInfoId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((facilityId == null) ? 0 : facilityId.hashCode());
		result = prime * result + ((facilityName == null) ? 0 : facilityName.hashCode());
		result = prime * result + ((isActiveForRental == null) ? 0 : isActiveForRental.hashCode());
		result = prime * result + ((schoolId == null) ? 0 : schoolId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facility other = (Facility) obj;
		if (facilityId == null) {
			if (other.facilityId != null)
				return false;
		} else if (!facilityId.equals(other.facilityId))
			return false;
		if (facilityName == null) {
			if (other.facilityName != null)
				return false;
		} else if (!facilityName.equals(other.facilityName))
			return false;
		if (isActiveForRental == null) {
			if (other.isActiveForRental != null)
				return false;
		} else if (!isActiveForRental.equals(other.isActiveForRental))
			return false;
		if (schoolId == null) {
			if (other.schoolId != null)
				return false;
		} else if (!schoolId.equals(other.schoolId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Facility [facilityId=" + facilityId + ", schoolId=" + schoolId + ", facilityName=" + facilityName
				+ ", facilityLocation=" + facilityLocation + ", facilityDesciption=" + facilityDesciption
				+ ", totalSeatingCapacity=" + totalSeatingCapacity + ", bookedFrom=" + bookedFrom + ", bookedTo="
				+ bookedTo + ", isActiveForRental=" + isActiveForRental + ", pricePerHour=" + pricePerHour + "]";
	}

	
}
