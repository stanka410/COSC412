package com.eventzone.cosc412.repository.custom;

import java.util.List;

import com.eventzone.cosc412.dto.FacilityDTO;
import com.eventzone.cosc412.model.Facility;

public interface CustomFacilityDAO {
	public List<Facility> getFacilityBySchool(String schoolName);
	public List<FacilityDTO> getLandingFacility();
}
