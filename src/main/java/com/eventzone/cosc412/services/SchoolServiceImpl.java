package com.eventzone.cosc412.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventzone.cosc412.model.School;
import com.eventzone.cosc412.repository.SchoolDAO;



@Service("schoolService")
public class SchoolServiceImpl implements SchoolService{

	@Autowired
	private SchoolDAO schoolRepository;

	@Override
	public School findBySchoolRepId(Long schoolRepId) {
		
		return schoolRepository.findBySchoolRepId(schoolRepId);
	}

	@Override
	public School findBySchoolId(Long schoolId) {
		return schoolRepository.findBySchoolId(schoolId);
	}
   

}
