package com.eventzone.cosc412.repository.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.hibernate.transform.Transformers;
import org.hibernate.type.LongType;

import com.eventzone.cosc412.dto.FacilityDTO;
import com.eventzone.cosc412.model.Facility;
import com.eventzone.cosc412.repository.custom.CustomFacilityDAO;

public class FacilityDAOImpl implements CustomFacilityDAO{

	@PersistenceContext
    private EntityManager em;
	
	@Override
	public List<Facility> getFacilityBySchool(String schoolName) {
		Query q = em.createNativeQuery("SELECT a from facility a, school b where a.school_id = b.school_id and b.school_name = :schoolNameParam");
		q.setParameter("schoolNameParam", schoolName);
		List<Facility> returnValue = q.getResultList();
		return returnValue;
	}

	@Override
	public List<FacilityDTO> getLandingFacility() {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a.facility_id, a.booked_from, a.booked_to, a.facility_description, a.facility_location, a.price_per_hour, a.total_seating_capacity, ");
		sb.append("b.school_name, c.street_address, c.city, c.state, c.zip from Facility a, School b, Address c ");
		sb.append("where a.school_id = b.school_id ");
		sb.append("and b.school_address_id = c.address_id ");
		sb.append("and ((a.booked_from > :timestamp or a.booked_from is null) or (a.booked_to is null or a.booked_to < :timestamp))" );
		
//		Query q = em.createQuery("SELECT a.facilityId, a.bookedFrom, a.bookedTo, a.facilityDesciption, "
//				+ " a.facilityLocation, a.pricePerHour, a.totalSeatingCapacity, b.schoolName, c.streetAddress, c.city , c.state, c.zip  from Facility a, "
//				+ "School b, "
//				+ "Address c "
//				+ "where a.schoolId = b.schoolId  "
//				+ "and b.schoolAddressId = c.addressId  "
//				+ "and ((a.bookedFrom > :timestamp or a.bookedFrom is null) or (a.bookedTo is null or a.bookedTo < :timestamp)");
		Query q = em.createNativeQuery(sb.toString());
		q.setParameter("timestamp", timestamp);
		List<FacilityDTO> returnValue = q.getResultList();
		for(FacilityDTO fdto: returnValue)
		{
			System.out.println(fdto.getFacilityName());
		}
		
		
		return returnValue;
	}

}
