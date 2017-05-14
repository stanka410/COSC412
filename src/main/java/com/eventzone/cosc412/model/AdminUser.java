package com.eventzone.cosc412.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity (name = "ADMIN_USER")
public class AdminUser {

    @Id
    @GeneratedValue
    Long adminUserId;
    
    @Column(name = "USER_ID")
    Long userId;

	public Long getCustomerId() {
		return adminUserId;
	}

	public void setCustomerId(Long customerId) {
		this.adminUserId = customerId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adminUserId == null) ? 0 : adminUserId.hashCode());
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
		AdminUser other = (AdminUser) obj;
		if (adminUserId == null) {
			if (other.adminUserId != null)
				return false;
		} else if (!adminUserId.equals(other.adminUserId))
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
		return "Customer [customerId=" + adminUserId + ", userId=" + userId + "]";
	}
  
}
