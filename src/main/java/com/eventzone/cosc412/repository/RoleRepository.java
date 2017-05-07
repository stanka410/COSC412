package com.eventzone.cosc412.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventzone.cosc412.model.UserRole;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<UserRole, Long>{
	UserRole findByUserRole(String role);

}
