package com.eventzone.cosc412.services;

import com.eventzone.cosc412.model.School;

public interface SchoolService {
	public School findBySchoolRepId(Long schoolRepId);

	public School findBySchoolId(Long schoolId);
}
