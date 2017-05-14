package com.eventzone.cosc412.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="SCHOOL_REPRESENTATIVE")
public class SchoolRepresentative {

    @Id
    @GeneratedValue
    Long schoolRepId;
    
    @Column(name = "USER_ID")
    Long userId;
    
    @Column(name = "SCHOOL_ID")
    Long schoolId;

	public Long getCustomerId() {
		return schoolRepId;
	}

	public void setCustomerId(Long customerId) {
		this.schoolRepId = customerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getTicketId() {
		return schoolId;
	}

	public void setTicketId(Long ticketId) {
		this.schoolId = ticketId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((schoolRepId == null) ? 0 : schoolRepId.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		SchoolRepresentative other = (SchoolRepresentative) obj;
		if (schoolRepId == null) {
			if (other.schoolRepId != null)
				return false;
		} else if (!schoolRepId.equals(other.schoolRepId))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + schoolRepId + ", userId=" + userId + ", ticketId=" + schoolId + "]";
	}
  
}
