package com.eventzone.cosc412.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity 
@Table (name="USER_ROLE")
public class UserRole implements  Comparable<UserRole>{

	@Id
    @GeneratedValue
    Long userRoleId;

    @Column(name = "USER_ROLE")
    String userRole;
    
    @Column(name = "ROLE_SHORT_DESCRIPTION")
    String roleShortDescription;

	public String getRoleShortDescription() {
		return roleShortDescription;
	}


	public void setRoleShortDescription(String roleShortDescription) {
		this.roleShortDescription = roleShortDescription;
	}


	public Long getUserRoleId() {
		return userRoleId;
	}


	public void setUserRoleId(Long userRoleId) {
		this.userRoleId = userRoleId;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((userRole == null) ? 0 : userRole.hashCode());
		result = prime * result + ((userRoleId == null) ? 0 : userRoleId.hashCode());
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
		UserRole other = (UserRole) obj;
		if (userRole == null) {
			if (other.userRole != null)
				return false;
		} else if (!userRole.equals(other.userRole))
			return false;
		if (userRoleId == null) {
			if (other.userRoleId != null)
				return false;
		} else if (!userRoleId.equals(other.userRoleId))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userRole=" + userRole + ", roleShortDescription="
				+ roleShortDescription + "]";
	}


	@Override
	public int compareTo(UserRole o) {
		return this.roleShortDescription.compareTo(o.roleShortDescription);
	}
 
}
