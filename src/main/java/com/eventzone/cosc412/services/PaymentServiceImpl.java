package com.eventzone.cosc412.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventzone.cosc412.dto.PaymentDTO;
import com.eventzone.cosc412.model.Payment;
import com.eventzone.cosc412.repository.PaymentDAO;
import com.stripe.model.Charge;



@Service("payemntService")
public class PaymentServiceImpl implements PaymentService{

	@Autowired
	PaymentDAO paymentDAO;

	
	@Override
	public Payment savePayemnt(Charge charge, PaymentDTO paymentDTO) {
		Payment payment = new Payment();
		
		payment.setCardHolderName(paymentDTO.getCardHolderName());
		payment.setExpDate(paymentDTO.getExpDate());
		payment.setFacilityID(paymentDTO.getFacilityId());
		payment.setTotalPrice(paymentDTO.getPricePerHour() * paymentDTO.getTotalHour());
		payment.setPaymentInfo(charge.getId() + "<>" + charge.getBalanceTransaction() + "<>" + paymentDTO.getCardNumber());
		payment.setUserInfoId(paymentDTO.getUserInfoId());
		payment.setSchoolID(paymentDTO.getSchoolId());
		return paymentDAO.save(payment);
	}


}
