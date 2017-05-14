package com.eventzone.cosc412.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventzone.cosc412.model.School;

@Repository("schoolDAO")
public interface SchoolDAO extends JpaRepository<School, Long>{
	public School findBySchoolRepId(Long schoolRepId);

	public School findBySchoolId(Long schoolId);

}
