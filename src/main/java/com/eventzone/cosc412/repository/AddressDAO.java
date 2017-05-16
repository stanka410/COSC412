/**
 * 
 */
package com.eventzone.cosc412.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventzone.cosc412.model.Address;

public interface AddressDAO extends JpaRepository<Address, Long> {
	public Address findByAddressId(Long addressId);
}
