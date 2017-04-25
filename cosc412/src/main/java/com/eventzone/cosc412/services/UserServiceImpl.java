package com.eventzone.cosc412.services;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.eventzone.cosc412.dto.RegistrationDTO;
import com.eventzone.cosc412.model.Address;
import com.eventzone.cosc412.model.UserInfo;
import com.eventzone.cosc412.model.UserRole;
import com.eventzone.cosc412.repository.AddressDAO;
import com.eventzone.cosc412.repository.RoleRepository;
import com.eventzone.cosc412.repository.UserRepository;



@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	@Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private AddressDAO addressDAO;
	
	@Override
	public UserInfo findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public void saveUser(UserInfo user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setActive(1);
        UserRole userRole = roleRepository.findByUserRole("ADMIN");
        user.setRoles(new HashSet<UserRole>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

	@Transactional(rollbackOn = Exception.class)
	@Override
	public void saveRegistrationInfo(RegistrationDTO registrationDTO) {
		UserInfo userInfo = new UserInfo();
		Address address = new Address();
		
		address.setCity(registrationDTO.getCity());
		address.setState(registrationDTO.getState());
		address.setStreetAddress(registrationDTO.getStreetAddress());
		address.setZip(registrationDTO.getZip());
		address = addressDAO.save(address);
		
		userInfo.setActive(1);
		userInfo.setCreatedDate(new Date());
		userInfo.setAddressId(address.getAddressId());
		userInfo.setEmail(registrationDTO.getEmail());
		userInfo.setFirstName(registrationDTO.getFirstName());
		userInfo.setLastName(registrationDTO.getLastName());
		userInfo.setPhone(registrationDTO.getPhone());
		if(!CollectionUtils.isEmpty(registrationDTO.getRoles())){
			userInfo.setRoles(registrationDTO.getRoles());
		}
		else{
			UserRole userRoles = roleRepository.findByUserRole("USER");
			userInfo.setRoles(new HashSet<UserRole>(Arrays.asList(userRoles)));
		}
		userInfo.setPassword(bCryptPasswordEncoder.encode(registrationDTO.getPassword()));
		userRepository.save(userInfo);
		
		
	}

}
