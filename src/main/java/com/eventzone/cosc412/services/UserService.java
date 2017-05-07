package com.eventzone.cosc412.services;

import com.eventzone.cosc412.dto.RegistrationDTO;
import com.eventzone.cosc412.model.UserInfo;

public interface UserService {
	public UserInfo findUserByEmail(String email);
	public void saveUser(UserInfo user);
	public void saveRegistrationInfo(RegistrationDTO registrationDTO);
}
