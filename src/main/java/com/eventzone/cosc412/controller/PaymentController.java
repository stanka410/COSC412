package com.eventzone.cosc412.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eventzone.cosc412.dto.PaymentDTO;
import com.eventzone.cosc412.model.UserInfo;
import com.eventzone.cosc412.services.PaymentService;
import com.eventzone.cosc412.services.UserService;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.net.RequestOptions;
import com.stripe.net.RequestOptions.RequestOptionsBuilder;


@Controller
public class PaymentController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PaymentService paymentService;
	
	 @RequestMapping(value = "/make-payment", method = RequestMethod.POST)
	    public ModelAndView makePayment(PaymentDTO paymentDTO,  BindingResult bindingResult,
	            ModelAndView modelAndView) {
//	    	RequestOptions options = RequestOptions.builder()
//	    		    .setConnectTimeout(30 * 1000) // in milliseconds
//	    		    .setReadTimeout(80 * 1000)
//	    		    .build();
//	    		Charge.create(params, options);
//	    	
	    	//String token = request.getParametner("stripeToken");
	    	
	    	
	    	// Create a Customer:
		
	    	
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
			else
			{
				paymentDTO.setUserInfoId(userExists.getUserInfoId());
		    	
		    	Stripe.setConnectTimeout(30 * 1000); // in milliseconds
		    	Stripe.setReadTimeout(80 * 1000);
		    	RequestOptions requestOptions = (new RequestOptionsBuilder()).setApiKey("sk_test_YuBrvzPGaMckdHvjETRl4nIw").build();
	
				Map<String, Object> chargeParams = new HashMap<String, Object>();
				chargeParams.put("amount", Integer.valueOf((int) (paymentDTO.getTotalHour() * paymentDTO.getPricePerHour() * 100))); //amount in cent
		    	chargeParams.put("currency", "usd");
		    	chargeParams.put("description", "Renting Facility " + paymentDTO.getFacilityName());
		    	
		        Map<String, Object> cardMap = new HashMap<String, Object>();
		        cardMap.put("number", paymentDTO.getCardNumber());
		        String exp[] = paymentDTO.getExpDate().split("/");
		        cardMap.put("exp_month", exp[0]);
		        cardMap.put("exp_year", exp[1]);
		        chargeParams.put("card", cardMap);
		        Charge charge = null;
		        try {
		            charge = Charge.create(chargeParams, requestOptions);
					modelAndView.addObject("successMessage", "Successfully processed payment for : $" + charge.getAmount()/100 + ", status: " + charge.getStatus() +
							", Confirmation Number: " + charge.getId());
			        paymentService.savePayemnt(charge, paymentDTO);
	
		        } catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException
						| APIException e)  {
		            e.printStackTrace();
					modelAndView.addObject("paymentDTO", paymentDTO);
					modelAndView.addObject("errorMsg", "Error occured while processing payment. Please try again later. " + e.getMessage());
	
		        }
			}
//	    	Map<String, Object> customerParams = new HashMap<String, Object>();
//	    	customerParams.put("email", userExists.getEmail());
//	    	customerParams.put("source", stripeToken);
//	    	Customer customer = null;
//			try {
//				customer = Customer.create(customerParams);
//			} catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException
//					| APIException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//	    	// Charge the Customer instead of the card:
//	    	Map<String, Object> chargeParams = new HashMap<String, Object>();
//	    	chargeParams.put("amount", paymentDTO.getTotalHour() * paymentDTO.getPricePerHour());
//	    	chargeParams.put("currency", "usd");
//	    	chargeParams.put("customer", customer.getId());
//	    	chargeParams.put("description", "Renting Facility " + paymentDTO.getFacilityName());
//	    	Map<String, String> initialMetadata = new HashMap<String, String>();
//	    	initialMetadata.put("schoolName", paymentDTO.getSchoolName());
//	    	initialMetadata.put("cardHolderName", paymentDTO.getCardHolderName());
//	    	chargeParams.put("metadata", initialMetadata);
//	    	Charge charge = null;
//	    	try {
//				 charge = Charge.create(chargeParams);
//					modelAndView.addObject("successMessage", "Successfully processed payment" + charge.getInvoice());
//
//			} catch (AuthenticationException | InvalidRequestException | APIConnectionException | CardException
//					| APIException e) {
//				// TODO Auto-generated catch block
//				modelAndView.addObject("paymentDTO", paymentDTO);
//				modelAndView.addObject("errorMsg", "Error occured while processing payment. Please try again later");
//
//				e.printStackTrace();
//			}
//	    	System.out.println(charge);
	    	modelAndView.setViewName("make-payment");
//	    	
//	    	

//	        
	        return modelAndView;
	    }

}
