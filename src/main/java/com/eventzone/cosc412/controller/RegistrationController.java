package com.eventzone.cosc412.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventzone.cosc412.dto.RegistrationDTO;
import com.eventzone.cosc412.model.UserInfo;
import com.eventzone.cosc412.repository.RoleRepository;
import com.eventzone.cosc412.services.CacheSchedularService;
import com.eventzone.cosc412.services.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	private UserService userService;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	CacheSchedularService cacheSchedularService;
	
	
	@RequestMapping(value="/register-school-rep", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("registrationDTO", cacheSchedularService.getAllUserRole());
		RegistrationDTO rdto = new RegistrationDTO();
		rdto.setRoles(cacheSchedularService.getAllUserRole());
		modelAndView.addObject("registrationDTO", rdto);
		modelAndView.setViewName("register-school-rep");
		return modelAndView;
	}
	
	@RequestMapping(value = "/register-school-rep", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid RegistrationDTO registrationDTO, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		RegistrationDTO rdto = new RegistrationDTO();
		
		UserInfo userExists = userService.findByEmailAndRole(registrationDTO.getEmail(), "SCHOOLREP");
		if (userExists != null) {
//			Set<UserRole> userRoles = userExists.getRoles();
//			for(UserRole userRole : userRoles)
//			{
//				if("SCHOOLREP".equals(userRole.getUserRole()))
//				{
					bindingResult
					.rejectValue("email", "error.user",
							"There is already a school rep registered with the email provided. One email can be registered to only one school");
					rdto = registrationDTO;
//					break;
//				}
//			}
		}
//		if (StringUtils.isBlank(registrationDTO.getReTypePassword()) || registrationDTO.getReTypePassword().equals(registrationDTO.getPassword())) {
//			bindingResult
//					.rejectValue("reTypePassword", "error.rePassword",
//							"The password and its confirm are not the same.");
//			rdto = registrationDTO;
//		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("register-school-rep");
			rdto = registrationDTO;
		} else {
//			if(!roles.isEmpty())
//			{
//				Set<UserRole> newRoles = roles.stream().map(userRoleId ->roleRepository.findOne(userRoleId)).collect(Collectors.toSet());
//				registrationDTO.setRoles(newRoles);
//			}
			
		  
			userService.saveRegistrationInfo(registrationDTO, "SCHOOLREP");
		
			//userService.saveUser(user);
			modelAndView.addObject("successMessage", "School Rep has been registered successfully");
			//modelAndView.addObject("user", new UserInfo());

			modelAndView.setViewName("register-school-rep");
			
		}
		rdto.setRoles(cacheSchedularService.getAllUserRole());
		modelAndView.addObject("registrationDTO", rdto);
		return modelAndView;
	}
	
	
	
	

}
