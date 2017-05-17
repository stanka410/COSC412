package com.eventzone.cosc412.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventzone.cosc412.dto.EventDTO;
import com.eventzone.cosc412.dto.RegistrationDTO;
import com.eventzone.cosc412.model.Address;
import com.eventzone.cosc412.model.UserInfo;
import com.eventzone.cosc412.repository.AddressDAO;
import com.eventzone.cosc412.repository.UserInfoDAO;
import com.eventzone.cosc412.services.EventsService;


@Controller
public class EventController {
	
	
	@Autowired
	private UserInfoDAO userRepository;
	
	@Autowired
	private AddressDAO addressRepository;
	@Autowired
	private EventsService eventsService;
	
	
	private UserInfo userInfo;
	private Address address;
	private RegistrationDTO registration;


	@RequestMapping(value={"/admin/add-events"}, method = RequestMethod.GET)
	public ModelAndView addEventsForm(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("eventDTO", new EventDTO());
		modelAndView.setViewName("admin/add-events");
		return modelAndView;
	}
	
	@RequestMapping(value={"/admin/add-events"}, method = RequestMethod.POST)
	public ModelAndView saveEvent(@Valid EventDTO eventDTO, BindingResult bindingResult, ModelAndView modelAndView1){
		System.out.println(modelAndView1.getModel());
		
		boolean success = eventsService.saveEvents(eventDTO);
		ModelAndView modelAndView = new ModelAndView();
		if(success){
			modelAndView.addObject("successMessage", "Successfully added event: " + eventDTO.getEventName()) ;
		}else{
			modelAndView.addObject("errorMessage", eventDTO.getEventName() + " could not be added. Please Try again later") ;
		}
		
		modelAndView.addObject("eventDTO", eventDTO);
		modelAndView.setViewName("admin/add-events");
		return modelAndView;
	}
	
	@RequestMapping(value={"/events"}, method = RequestMethod.GET)
	public ModelAndView getEvents(){
		List<EventDTO> eventDTOs = new ArrayList<>();
		ModelAndView modelAndView = new ModelAndView();
		 eventDTOs = eventsService.findAllEvents();
		modelAndView.addObject("eventDTOs", eventDTOs);
		modelAndView.setViewName("all-events");
		return modelAndView;
	}


}
