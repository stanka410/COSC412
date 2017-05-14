package com.eventzone.cosc412.services;

import java.util.List;

import com.eventzone.cosc412.dto.RegistrationDTO;
import com.eventzone.cosc412.model.UserInfo;

public interface UserService {
	public UserInfo findUserByEmail(String email);
	public UserInfo findByEmailAndRole(String email, String role);
	public void saveUser(UserInfo user);
	public void saveRegistrationInfo(RegistrationDTO registrationDTO, String accountType);
	
	public UserInfo getLoggedInUser();
	public UserInfo findUserByUserInfoId(Long userInfoId);
	public UserInfo findByEmailAndRoles(String email, List<String> roles);
}
