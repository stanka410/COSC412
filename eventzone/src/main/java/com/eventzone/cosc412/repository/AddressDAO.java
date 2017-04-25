/**
 * 
 */
package com.eventzone.cosc412.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventzone.cosc412.model.Address;


/**
 * @author sheilan89
 *
 */
public interface AddressDAO extends JpaRepository<Address, Long> {

}
