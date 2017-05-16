package com.eventzone.cosc412.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventzone.cosc412.dto.FacilityDTO;
import com.eventzone.cosc412.model.Address;
import com.eventzone.cosc412.model.Facility;
import com.eventzone.cosc412.model.School;
import com.eventzone.cosc412.repository.FacilityDAO;



@Service("facilityService")
public class FacilityServiceImpl implements FacilityService{

	@Autowired
	private FacilityDAO facilityDAO;
	
	@Autowired
	private SchoolService schoolService;
	
	@Autowired
	private AddressService addressService;
	

	@Override
	public List<FacilityDTO> getLandingFacility() {
		List<FacilityDTO> fdtos =  new ArrayList<> ();// facilityDAO.getLandingFacility();
		List<Facility> facilityList = findFacility();
	
		for(Facility facility : facilityList)
		{
			if(fdtos.size() >= 10)
			{
				break;
			}
			
			FacilityDTO fdto = new FacilityDTO();
			School school = schoolService.findBySchoolId(facility.getSchoolId());
			Address address = addressService.findByAddressId(school.getSchoolAddressId());
			fdto.setFacilityId(facility.getFacilityId());
			fdto.setFacilityName(facility.getFacilityName());
			fdto.setFacilityDescription(facility.getFacilityDesciption());
			fdto.setFacilityLocation(facility.getFacilityLocation());
			fdto.setBookedFrom(facility.getBookedFrom());
			fdto.setBookedTo(facility.getBookedTo());
			fdto.setPricePerHour(facility.getPricePerHour());
			fdto.setSchoolAddress(address.getStreetAddress() + " " + address.getCity() + " " + address.getState() + " " + address.getZip());
			fdto.setSchoolId(school.getSchoolId());
			fdto.setSchoolName(school.getSchoolName());
			
			fdtos.add(fdto);
			
		}
		
		return fdtos;
	}

	@Override
	public void saveFacility(FacilityDTO facilityDTO) {
		Facility facility = new Facility();
		facility.setAddedByUserInfoId(facilityDTO.getAddedBy());
		facility.setBookedFrom(facilityDTO.getBookedFrom());
		facility.setBookedTo(facilityDTO.getBookedTo());
		facility.setFacilityDesciption(facilityDTO.getFacilityDescription());
		facility.setFacilityLocation(facilityDTO.getFacilityLocation());
		facility.setFacilityName(facilityDTO.getFacilityName());
		facility.setIsActiveForRental(facilityDTO.getIsActiveForRental());
		facility.setPricePerHour(facilityDTO.getPricePerHour());
		facility.setSchoolId(facilityDTO.getSchoolId());
		if(facilityDTO.getFacilityId() != null)
		{
			facility.setFacilityId(facilityDTO.getFacilityId());
		}
		facilityDAO.save(facility);
	}

	@Override
	public List<Facility> findBySchoolId(Long schoolId) {
		return facilityDAO.findBySchoolId(schoolId);
	}

	@Override
	public Facility findByfacilityId(Long facilityId) {
		return facilityDAO.findByFacilityId(facilityId);
	}

	@Override
	public void delete(Facility facility) {
		facilityDAO.delete(facility);
		
	}

	@Override
	public List<Facility> findFacility() {
		return facilityDAO.findAll();
	}

	@Override
	public FacilityDTO getLandingFacilityById(Long facilityId) {
		Facility facility = findByfacilityId(facilityId);

		FacilityDTO fdto = new FacilityDTO();
		School school = schoolService.findBySchoolId(facility.getSchoolId());
		Address address = addressService.findByAddressId(school.getSchoolAddressId());
		fdto.setFacilityId(facilityId);
		fdto.setFacilityName(facility.getFacilityName());
		fdto.setFacilityDescription(facility.getFacilityDesciption());
		fdto.setFacilityLocation(facility.getFacilityLocation());
		fdto.setBookedFrom(facility.getBookedFrom());
		fdto.setBookedTo(facility.getBookedTo());
		fdto.setPricePerHour(facility.getPricePerHour());
		fdto.setSchoolAddress(address.getStreetAddress() + " " + address.getCity() + " " + address.getState() + " "
				+ address.getZip());
		fdto.setSchoolId(school.getSchoolId());
		fdto.setSchoolName(school.getSchoolName());

		return fdto;
	}
	

}
