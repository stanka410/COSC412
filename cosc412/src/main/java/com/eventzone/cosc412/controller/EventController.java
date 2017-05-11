package com.eventzone.cosc412.controller;

import java.util.List;

import javax.servlet.Registration;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eventzone.cosc412.dto.RegistrationDTO;
import com.eventzone.cosc412.model.Address;
import com.eventzone.cosc412.model.Record;
import com.eventzone.cosc412.model.UserInfo;
import com.eventzone.cosc412.repository.AddressDAO;
import com.eventzone.cosc412.repository.RecordRepository;
import com.eventzone.cosc412.repository.UserInfoDAO;


@Controller
@RequestMapping("/pages/")
public class EventController {

	@Autowired
	private RecordRepository repository;

	@Autowired
	private UserInfoDAO userRepository;

	@Autowired
	private AddressDAO addressRepository;


	private UserInfo userInfo;
	private Address address;
	private RegistrationDTO registration;

//    @Autowired
//    public EventController(RecordRepository repository) {
//        this.repository = repository;
//    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {
        List<Record> records = repository.findAll();
        model.addAttribute("records", records);
        model.addAttribute("insertRecord", new Record());
        return "home";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String register(ModelMap model) {
        return resultRegistration(model);
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addNewUser(@Valid Registration registration, BindingResult result, ModelMap model) {

		System.out.println(registration.toString());



		 if (!result.hasErrors()) {
	            return resultRegistration(model);
	        }
	        return "add-user";

    }


   // @RequestMapping(method = RequestMethod.GET)
    public String resultRegistration(ModelMap model) {
        //List<Record> records = repository.findAll();

    	userInfo = new UserInfo();
    	userInfo.setFirstName("fn");
    	userInfo.setLastName("fn");
    	userInfo.setEmail("fn@ao.com");
    	userInfo.setPhone("");

    	address = new Address();
    	address.setCity("city");
    	address.setState("coun");
    	address.setStreetAddress("Str");
    	address.setZip("3233");
    	model.addAttribute("registration", new RegistrationDTO());
        return "add-user";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String insertData(ModelMap model,
                             @ModelAttribute("insertRecord") @Valid Record record,
                             BindingResult result) {
        if (!result.hasErrors()) {
            repository.save(record);
            return home(model);
        }
        return "home";
    }

}
