package com.eventzone.cosc412.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity (name = "SCHOOL")
public class School {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SCHOOL_ID_SEQ")
    @SequenceGenerator(sequenceName = "uSCHOOL_ID_seq", initialValue = 1, allocationSize = 1, name = "SCHOOL_ID_SEQ")
	@Column(name = "SCHOOL_ID")
	Long schoolId;
	
	
    @Column(name = "SCHOOL_NAME")
    String schoolName;
    
    @Column(name = "SCHOOL_ADDRESS")
    String schoolAddress;
    
    @Column(name = "PHONE")
    int phone;
    
    @Column(name = "SCHOOL_REP_ID")
    String schoolRepId;

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

	public String getSchoolAddress() {
		return schoolAddress;
	}

	public void setSchoolAddress(String schoolAddress) {
		this.schoolAddress = schoolAddress;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getSchoolRepId() {
		return schoolRepId;
	}

	public void setSchoolRepId(String schoolRepId) {
		this.schoolRepId = schoolRepId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + phone;
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
		if (phone != other.phone)
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

	@Override
	public String toString() {
		return "School [schoolId=" + schoolId + ", schoolName=" + schoolName + ", schoolAddress=" + schoolAddress
				+ ", phone=" + phone + ", schoolRepId=" + schoolRepId + "]";
	}
    
 
}
