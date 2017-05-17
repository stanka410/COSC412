package com.eventzone.cosc412.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eventzone.cosc412.dto.FacilityDTO;
import com.eventzone.cosc412.dto.PaymentDTO;
import com.eventzone.cosc412.model.Address;
import com.eventzone.cosc412.model.Facility;
import com.eventzone.cosc412.model.School;
import com.eventzone.cosc412.model.UserInfo;
import com.eventzone.cosc412.repository.AddressDAO;
import com.eventzone.cosc412.services.FacilityService;
import com.eventzone.cosc412.services.SchoolService;
import com.eventzone.cosc412.services.UserService;

@Controller
public class FacilityController {
	
	@Autowired
	private UserService userService;

	@Autowired
	FacilityService facilityService;
	
	@Autowired
	SchoolService schoolService;
	
	@Autowired
	AddressDAO addressDAO;
	
	
	@RequestMapping(value="/search-facility", method = RequestMethod.GET)
	public ModelAndView searchFacility(){
		ModelAndView modelAndView = new ModelAndView();
		List<FacilityDTO> fdtos = new ArrayList<>();
//		RegistrationDTO rdto = new RegistrationDTO();
//		rdto.setRoles(cacheSchedularService.getAllUserRole());
//		modelAndView.addObject("registrationDTO", rdto);
		
		fdtos = (List<FacilityDTO>) facilityService.getLandingFacility();
		modelAndView.addObject("facilityDTOList", fdtos);
		modelAndView.setViewName("search-facility");
		return modelAndView;
	}
	
	@RequestMapping(value = "/rent-facility", method = RequestMethod.POST)
	public ModelAndView rentFacility(@RequestParam("facilityId") String facilityId,   
            ModelAndView modelAndView, BindingResult bindingResult) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    List<String> roles = new ArrayList<>();
	    roles.add("USER");
	    roles.add("ADMIN");
	    roles.add("SCHOOLREP");
	    roles.add("RENTER");
	    roles.add("CUSTOMER");
	    
	    UserInfo userExists = userService.findByEmailAndRoles(username, roles);
		
		if (userExists == null) {
					bindingResult
					.rejectValue("email", "error.user",
							"You should be logged In to Rent a facility");
		}
		
		FacilityDTO facilityDTO = facilityService.getLandingFacilityById(Long.valueOf(facilityId));
		
		if (bindingResult.hasErrors()) {
			modelAndView = searchFacility();
		} else {
			PaymentDTO paymentDTO = new PaymentDTO();
			paymentDTO.setFacilityDescription(facilityDTO.getFacilityDescription());
			paymentDTO.setSchoolAddress(facilityDTO.getSchoolAddress());
			paymentDTO.setSchoolName(facilityDTO.getSchoolName());
			paymentDTO.setSchoolId(facilityDTO.getSchoolId());
			paymentDTO.setFacilityName(facilityDTO.getFacilityName());
			paymentDTO.setFacilityLocation(facilityDTO.getFacilityLocation());
			paymentDTO.setTotalSeatingCapacity(facilityDTO.getTotalSeatingCapacity());
			paymentDTO.setPricePerHour(facilityDTO.getPricePerHour());
			paymentDTO.setFacilityId(facilityDTO.getFacilityId());
			modelAndView.addObject("paymentDTO", paymentDTO);
			modelAndView.setViewName("make-payment");
		}
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="schoolRep/add-facility", method = RequestMethod.GET)
	public ModelAndView addFacilty(){
		ModelAndView modelAndView = new ModelAndView();
		FacilityDTO fdto = new FacilityDTO();
		
		
		UserInfo userInfo = userService.getLoggedInUser();
		if(userInfo != null && "SCHOOLREP".equals(userInfo.getAccountType()))
		{
			School school = schoolService.findBySchoolRepId(userInfo.getId());
			Address address = addressDAO.findByAddressId(school.getSchoolAddressId());
			fdto.setSchoolName(school.getSchoolName());
			fdto.setSchoolAddress(address.getStreetAddress() + " " + address.getCity() + " " + address.getState() + " " + address.getZip());
			fdto.setSchoolId(school.getSchoolId());
		}
		else{
			modelAndView.addObject("errorMessage", "You should be School Rep to add facility!");
		}
		
//		RegistrationDTO rdto = new RegistrationDTO();
//		rdto.setRoles(cacheSchedularService.getAllUserRole());
//		modelAndView.addObject("registrationDTO", rdto);
		//fdtos = facilityService.getLandingFacility();
		modelAndView.addObject("facilityDTO", fdto);
		modelAndView.setViewName("schoolRep/add-facility");
		return modelAndView;
	}
	
	@RequestMapping(value = "schoolRep/add-facility", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid FacilityDTO facilityDTO, BindingResult bindingResult) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    UserInfo userExists = userService.findByEmailAndRole(username, "SCHOOLREP");
		
		if (userExists == null) {
					bindingResult
					.rejectValue("email", "error.user",
							"Ther is issue with your username. Please try again later");
		}
		
		ModelAndView modelAndView = new ModelAndView();
		FacilityDTO fdto = new FacilityDTO();
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("schoolRep/add-facility");
			fdto = facilityDTO;
		} else {
			
			if(facilityDTO.getAddedBy() != null){
				facilityDTO.setAddedBy(userExists.getUserInfoId());
			}
			else{
			facilityDTO.setAddedBy(userExists.getUserInfoId());
			}
			
			facilityService.saveFacility(facilityDTO);
		
			//userService.saveUser(user);
			modelAndView.addObject("successMessage", facilityDTO.getFacilityName() + " has been saved successfully");
			modelAndView.addObject("facilityDTO", facilityDTO);

			modelAndView.setViewName("search-facility");
			
		}
		modelAndView.addObject("facilityDTO", fdto);
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/schoolRep/edit-facility", method = RequestMethod.POST)
	public ModelAndView editFacility(@RequestParam("facilityId") String facilityId,ModelAndView modelAndView){
		Facility facility = facilityService.findByfacilityId(Long.valueOf(facilityId));
		School school = schoolService.findBySchoolId(facility.getSchoolId());
		UserInfo userInfo = userService.findUserByUserInfoId(facility.getAddedByUserInfoId());
		
		FacilityDTO fdto = new FacilityDTO();
		fdto.setAddedBy(facility.getAddedByUserInfoId());
		fdto.setBookedFrom(facility.getBookedFrom());
		fdto.setBookedTo(facility.getBookedTo());
		fdto.setFacilityDescription(facility.getFacilityDesciption());
		fdto.setFacilityLocation(facility.getFacilityLocation());
		fdto.setFacilityName(facility.getFacilityName());
		fdto.setIsActiveForRental(facility.getIsActiveForRental());
		fdto.setPricePerHour(facility.getPricePerHour());
		fdto.setSchoolName(school.getSchoolName());
		fdto.setSchoolId(school.getSchoolId());
		fdto.setAddedBy(userInfo.getUserInfoId());
		fdto.setFacilityId(facility.getFacilityId());
		
		if(facility.getBookedTo() != null || facility.getBookedFrom() != null)
		{
			modelAndView.addObject("errorMessage", facility.getFacilityName() + " cannot be updated at this time. It still have bookings.");
			modelAndView.setViewName("schoolRep/facility-management");
		}
		else
		{
			modelAndView.addObject("facilityDTO", fdto);
			modelAndView.setViewName("add-facility");
			
		}
		return modelAndView;
	}
	
	@RequestMapping(value = "/schoolRep/remove-facility", method = RequestMethod.POST)
	public ModelAndView deleteFacility(@RequestParam("facilityId") String facilityId,   
            ModelAndView modelAndView) {
		//ModelAndView modelAndView = new ModelAndView();
		Facility facility = facilityService.findByfacilityId(Long.valueOf(facilityId));
		if(facility.getBookedTo() != null || facility.getBookedFrom() != null)
		{
			modelAndView.addObject("errorMessage", facility.getFacilityName() + " cannot be removed at this time. It still have bookings.");

		}
		else
		{
		facilityService.delete(facility);
		modelAndView.addObject("successMessage", facility.getFacilityName() + " has been successfully removed.");
		}
        // Set view.      
        return getAllFacility();
	}
	
	@RequestMapping(path="/schoolRep/facilityManagement", method=RequestMethod.GET)
	public ModelAndView getAllFacility(){
		ModelAndView modelAndView = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName();
	    
		UserInfo userExists = userService.findByEmailAndRole(username, "SCHOOLREP");
		
	    School school = schoolService.findBySchoolRepId(userExists.getUserInfoId());
		List<Facility> facilityList = facilityService.findBySchoolId(school.getSchoolId());
		modelAndView.addObject("facilityList", facilityList);
		
		modelAndView.setViewName("schoolRep/facility-management");
		return modelAndView;
	}
	
	
	
	

}
