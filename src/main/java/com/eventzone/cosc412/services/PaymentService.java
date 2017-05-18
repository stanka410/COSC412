package com.eventzone.cosc412.services;

import com.eventzone.cosc412.dto.PaymentDTO;
import com.eventzone.cosc412.model.Payment;
import com.stripe.model.Charge;

public interface PaymentService {
	public Payment savePayemnt(Charge charge, PaymentDTO paymentDTO);
}
