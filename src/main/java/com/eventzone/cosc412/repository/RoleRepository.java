package com.eventzone.cosc412.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.eventzone.cosc412.model.UserRole;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<UserRole, Long>{
	
	 @Query("select t from UserRole t where t.userRole in (?1, ?2)")
	List<UserRole> findUserRoleByRoleNames(String role1, String role2);
	 
	UserRole findByUserRole(String  role);

}
