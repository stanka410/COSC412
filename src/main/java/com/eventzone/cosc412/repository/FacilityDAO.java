package com.eventzone.cosc412.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventzone.cosc412.model.Facility;
import com.eventzone.cosc412.repository.custom.CustomFacilityDAO;

@Repository("facilityDAO")
public interface FacilityDAO extends JpaRepository<Facility, Long>, CustomFacilityDAO{
	public List<Facility> findBySchoolId(Long schoolId);
	public Facility findByFacilityId(Long facilityId);
	
}
