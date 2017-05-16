package com.eventzone.cosc412.controller;

import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eventzone.cosc412.dto.RegistrationDTO;
import com.eventzone.cosc412.model.UserInfo;
import com.eventzone.cosc412.model.UserRole;
import com.eventzone.cosc412.repository.RoleRepository;
import com.eventzone.cosc412.services.CacheSchedularService;
import com.eventzone.cosc412.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	CacheSchedularService cacheSchedularService;
	
	
	@RequestMapping(value={"/", "/index"}, method = RequestMethod.GET)
	public ModelAndView homePageNew(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	
	@RequestMapping(value="/error", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView error(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error");
		return modelAndView;
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("registrationDTO", cacheSchedularService.getAllUserRole());
		RegistrationDTO rdto = new RegistrationDTO();
		rdto.setRoles(cacheSchedularService.getAllUserRole());
		modelAndView.addObject("registrationDTO", rdto);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid RegistrationDTO registrationDTO, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		RegistrationDTO rdto = new RegistrationDTO();
		
		UserInfo userExists = userService.findByEmailAndRole(registrationDTO.getEmail(), "USER");
		if (userExists != null) {
//			Set<UserRole> userRoles = userExists.getRoles();
//			for(UserRole userRole : userRoles)
//			{
//				if("USER".equals(userRole.getUserRole()) || "CUSTOMER".equals(userRole.getUserRole()))
//				{
					bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
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
			modelAndView.setViewName("registration");
			rdto = registrationDTO;
		} else {
//			if(!roles.isEmpty())
//			{
//				Set<UserRole> newRoles = roles.stream().map(userRoleId ->roleRepository.findOne(userRoleId)).collect(Collectors.toSet());
//				registrationDTO.setRoles(newRoles);
//			}
			userService.saveRegistrationInfo(registrationDTO, "USER");
		
			//userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			//modelAndView.addObject("user", new UserInfo());

			modelAndView.setViewName("registration");
			
		}
		rdto.setRoles(cacheSchedularService.getAllUserRole());
		modelAndView.addObject("registrationDTO", rdto);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "admin/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid RegistrationDTO registrationDTO, BindingResult bindingResult, @RequestParam(value="newRoles") ArrayList<Long> roles) {
		ModelAndView modelAndView = new ModelAndView();
		RegistrationDTO rdto = new RegistrationDTO();
		
		UserInfo userExists = userService.findUserByEmail(registrationDTO.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
			rdto = registrationDTO;
		}
//		if (StringUtils.isBlank(registrationDTO.getReTypePassword()) || registrationDTO.getReTypePassword().equals(registrationDTO.getPassword())) {
//			bindingResult
//					.rejectValue("reTypePassword", "error.rePassword",
//							"The password and its confirm are not the same.");
//			rdto = registrationDTO;
//		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
			rdto = registrationDTO;
		} else {
			if(!roles.isEmpty())
			{
				Set<UserRole> newRoles = roles.stream().map(userRoleId ->roleRepository.findOne(userRoleId)).collect(Collectors.toSet());
				registrationDTO.setRoles(newRoles);
			}
			userService.saveRegistrationInfo(registrationDTO, "USER");
		
			//userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			//modelAndView.addObject("user", new UserInfo());

			modelAndView.setViewName("registration");
			
		}
		rdto.setRoles(cacheSchedularService.getAllUserRole());
		modelAndView.addObject("registrationDTO", rdto);
		return modelAndView;
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/admin/home", method = RequestMethod.POST)
	public ModelAndView homePage(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
	
	@RequestMapping(value="/schoolRep/home", method = RequestMethod.GET)
	public ModelAndView landing(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserInfo user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		if("SCHOOLREP".equals(user.getAccountType()))
		{
			modelAndView.setViewName("schoolRep/home");
		}
		else if("ADMIN".equals(user.getAccountType()))
		{
			modelAndView.setViewName("admin/home");
		}
		else
		{
			modelAndView.setViewName("/home");
		}
		return modelAndView;
	}

}
