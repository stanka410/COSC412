package com.eventzone.cosc412.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventzone.cosc412.model.Address;
import com.eventzone.cosc412.repository.AddressDAO;



@Service("addressService")
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressDAO addressRepository;

	@Override
	public Address findByAddressId(Long addressId){
		
		return addressRepository.findByAddressId(addressId);
	}
   

}
