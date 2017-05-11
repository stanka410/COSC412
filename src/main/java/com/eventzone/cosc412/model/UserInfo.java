package com.eventzone.cosc412.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity (name = "USER_INFO")
public class UserInfo {

	@Id
    @GeneratedValue

	Long userInfoId;
	
	@Column(name = "PASSWORD")
	String password; // we won't let JPA manage password persistence, we will encrypt and save.
	
    @Column(name = "FIRST_NAME")
    String firstName;
    
    @Column(name = "LAST_NAME")
    String lastName;
    
    @Column(name = "EMAIL")
    String email;
    
    @Column(name = "ACTIVE")
    int active;
    
    @Column(name = "PHONE_NUMBER")
    String phone;
    
    @Column(name = "ADDRESS_ID")
    Long addressId;
    
    @Temporal(TemporalType.DATE)
    @Column(name="DATE_OF_BIRTH")
    Date dateOfBirth;
    
    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_info_user_role", joinColumns = @JoinColumn(name = "USER_INFO_ID"), inverseJoinColumns = @JoinColumn(name = "user_Role_Id"))
	private Set<UserRole> roles;

    
    public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public Set<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserRole> roles) {
		this.roles = roles;
	}

	public Long getUserInfoId() {
		return userInfoId;
	}

	public void setUserInfoId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_DATE")
    private Date createdDate;

	public Long getId() {
		return userInfoId;
	}

	public void setId(Long userInfoId) {
		this.userInfoId = userInfoId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + active;
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((dateOfBirth == null) ? 0 : dateOfBirth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((roles == null) ? 0 : roles.hashCode());
		result = prime * result + ((userInfoId == null) ? 0 : userInfoId.hashCode());
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
		UserInfo other = (UserInfo) obj;
		if (active != other.active)
			return false;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (dateOfBirth == null) {
			if (other.dateOfBirth != null)
				return false;
		} else if (!dateOfBirth.equals(other.dateOfBirth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (roles == null) {
			if (other.roles != null)
				return false;
		} else if (!roles.equals(other.roles))
			return false;
		if (userInfoId == null) {
			if (other.userInfoId != null)
				return false;
		} else if (!userInfoId.equals(other.userInfoId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		Stringbuilder = new Stringbuilder(100);
		return sb.append("UserInfo [userInfoId=").append(userInfoId)
				.append(", password=").append(password)
				.append(", firstName=").append(firstName)
				.append(", lastName=").append(lastName)
				.append(", email=").append(email)
				.append(", active=").append(active)
				.append(", phone=").append(phone)
				.append(", addressId=").append(addressId)
				.append(", dateOfBirth=").append(dateOfBirth)
				.append(", roles=").append(roles)
				.append(", createdDate=").append(createdDate)
				.append("]")
				.toString();
	}
}
