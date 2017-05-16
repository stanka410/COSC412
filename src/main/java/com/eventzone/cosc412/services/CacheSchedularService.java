package com.eventzone.cosc412.services;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.eventzone.cosc412.model.UserRole;
import com.eventzone.cosc412.repository.RoleRepository;

@Service
public class CacheSchedularService {
    @Autowired
    RoleRepository roleRepository;
	
	@Cacheable("userRoleListCache")
    public Set<UserRole> getAllUserRole() {
		List<UserRole> userRoles = roleRepository.findAll();
		Collections.sort(userRoles);

//		simulateSlowService();
		
        return  new HashSet<UserRole>(userRoles);
    }
	
	 // Don't do this at home
//    private void simulateSlowService() {
//        try {
//            long time = 30000L;
//            Thread.sleep(time);
//        } catch (InterruptedException e) {
//            throw new IllegalStateException(e);
//        }
//    }

}