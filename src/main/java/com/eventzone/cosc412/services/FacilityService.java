package com.eventzone.cosc412.services;

import java.util.List;

import com.eventzone.cosc412.dto.FacilityDTO;
import com.eventzone.cosc412.model.Facility;

public interface FacilityService {
	public List<FacilityDTO> getLandingFacility();

	public void saveFacility(FacilityDTO facilityDTO);

	public List<Facility> findBySchoolId(Long schoolId);

	public Facility findByfacilityId(Long valueOf);

	public void delete(Facility facility);

	public List<Facility> findFacility();

	public FacilityDTO getLandingFacilityById(Long valueOf);
}
