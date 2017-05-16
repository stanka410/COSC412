package com.eventzone.cosc412.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table (name = "SCHOOL")
public class School {

	@Id
    @GeneratedValue
	@Column(name = "SCHOOL_ID")
	Long schoolId;
	
	
    @Column(name = "SCHOOL_NAME")
    String schoolName;
    
    @Column(name = "SCHOOL_ADDRESS_ID")
    Long schoolAddressId;
    
    @Column(name = "PHONE")
    String phone;
    
    @Column(name = "SCHOOL_REP_ID")
    Long schoolRepId;

	public Long getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	


	public Long getSchoolRepId() {
		return schoolRepId;
	}

	public void setSchoolRepId(Long schoolRepId) {
		this.schoolRepId = schoolRepId;
	}

	public Long getSchoolAddressId() {
		return schoolAddressId;
	}

	public void setSchoolAddressId(Long schoolAddressId) {
		this.schoolAddressId = schoolAddressId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((schoolId == null) ? 0 : schoolId.hashCode());
		result = prime * result + ((schoolName == null) ? 0 : schoolName.hashCode());
		result = prime * result + ((schoolRepId == null) ? 0 : schoolRepId.hashCode());
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
		School other = (School) obj;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (schoolId == null) {
			if (other.schoolId != null)
				return false;
		} else if (!schoolId.equals(other.schoolId))
			return false;
		if (schoolName == null) {
			if (other.schoolName != null)
				return false;
		} else if (!schoolName.equals(other.schoolName))
			return false;
		if (schoolRepId == null) {
			if (other.schoolRepId != null)
				return false;
		} else if (!schoolRepId.equals(other.schoolRepId))
			return false;
		return true;
	}


	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", schoolAddressId=" + schoolAddressId
				+ ", phone=" + phone + ", schoolRepId=" + schoolRepId + "]";
	}


 
}
