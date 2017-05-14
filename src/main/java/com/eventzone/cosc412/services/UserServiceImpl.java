package com.eventzone.cosc412.services;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.eventzone.cosc412.dto.RegistrationDTO;
import com.eventzone.cosc412.model.Address;
import com.eventzone.cosc412.model.School;
import com.eventzone.cosc412.model.UserInfo;
import com.eventzone.cosc412.model.UserRole;
import com.eventzone.cosc412.repository.AddressDAO;
import com.eventzone.cosc412.repository.RoleRepository;
import com.eventzone.cosc412.repository.SchoolDAO;
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
    
    @Autowired
    private SchoolDAO schoolDAO;
	
	@Override
	public UserInfo findUserByEmail(String email) {
		return userRepository.findByEmail(email);
		
	}
	
	@Override
	public UserInfo getLoggedInUser(){
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	     String username = auth.getName();
	     UserInfo userInfo = userRepository.findByEmail(username);
	     return userInfo;
	      
	}
	
	@Override
	public UserInfo findByEmailAndRole(String email, String role) {
		UserInfo returnValue = null; 
		UserInfo userInfo = userRepository.findByEmail(email);
		 if(userInfo != null)
		 {
			 Set<UserRole> userRoles = userInfo.getRoles();
			 for(UserRole userRole : userRoles)
			 {
				 if(role.equals(userRole.getUserRole())){
					 returnValue = userInfo;
					 break;
				 }
			 }
 		 }
		 return returnValue;
		
	}
	
	@Override
	public UserInfo findByEmailAndRoles(String email, List<String> roles) {
		UserInfo returnValue = null; 
		UserInfo userInfo = userRepository.findByEmail(email);
		 if(userInfo != null)
		 {
			 Set<UserRole> userRoles = userInfo.getRoles();
			 for(UserRole userRole : userRoles)
			 {
				 if(roles.contains(userRole.getUserRole())){
					 returnValue = userInfo;
					 break;
				 }
			 }
 		 }
		 return returnValue;
		
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
	public void saveRegistrationInfo(RegistrationDTO registrationDTO, String accountType) {
		UserInfo userInfo = new UserInfo();
		Address address = new Address();
		
		address.setCity(registrationDTO.getCity());
		address.setState(registrationDTO.getState());
		address.setStreetAddress(registrationDTO.getStreetAddress());
		address.setZip(registrationDTO.getZip());
		address = addressDAO.save(address);
		
		userInfo.setAddressId(address.getAddressId());
		userInfo.setAccountType(accountType);
		userInfo.setActive(1);
		userInfo.setCreatedDate(new Date());
		userInfo.setEmail(registrationDTO.getEmail());
		userInfo.setFirstName(registrationDTO.getFirstName());
		userInfo.setLastName(registrationDTO.getLastName());
		userInfo.setPhone(registrationDTO.getPhone());
		userInfo.setDateOfBirth(registrationDTO.getDateOfBirth());
		userInfo.setPassword(bCryptPasswordEncoder.encode(registrationDTO.getPassword()));
		
		if(accountType.equals("SCHOOLREP"))
		{
			List<UserRole> userRoles = roleRepository.findUserRoleByRoleNames("USER", "SCHOOLREP");
			if(!CollectionUtils.isEmpty(userRoles))
			{
				userInfo.setRoles(new HashSet<>(userRoles));
			}
			userInfo = userRepository.save(userInfo);
			
			School school = new School();
			school.setPhone(registrationDTO.getSchoolPhone());
			school.setSchoolAddressId(address.getAddressId());
			school.setSchoolName(registrationDTO.getSchoolName());
			school.setSchoolRepId(userInfo.getUserInfoId());
			
			schoolDAO.save(school);
			
		}
		else if(accountType.equals("USER"))
		{
			UserRole userRole = roleRepository.findByUserRole("USER");
			Set<UserRole>userRoles = new HashSet<>();
			if(userRole != null){
				userRoles.add(userRole);
			}
			userInfo.setRoles(new HashSet<>(userRoles));
			userRepository.save(userInfo);
		}
		else if(accountType.equals("ADMIN"))
		{
			UserRole userRole = roleRepository.findByUserRole("ADMIN");
			Set<UserRole>userRoles = new HashSet<>();
			if(userRole != null){
				userRoles.add(userRole);
			}
			userInfo.setRoles(new HashSet<>(userRoles));
			userRepository.save(userInfo);
		}
		
//		if(!CollectionUtils.isEmpty(registrationDTO.getRoles())){
//			userInfo.setRoles(registrationDTO.getRoles());
//		}
//		else{
//			UserRole userRole = roleRepository.findByUserRole("USER");
//			Set<UserRole>userRoles = new HashSet<>();
//			if(userRole != null){
//				userRoles.add(userRole);
//			}
//			userInfo.setRoles(new HashSet<>(userRoles));
//		}
		
	}

	@Override
	public UserInfo findUserByUserInfoId(Long userInfoId) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUserInfoId(userInfoId);
	}

}
