package com.eventzone.cosc412.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventzone.cosc412.model.UserRole;

@Repository("schoolDAO")
public interface SchoolDAO extends JpaRepository<UserRole, Long>{


}
