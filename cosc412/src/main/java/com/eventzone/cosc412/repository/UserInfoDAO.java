/**
 * 
 */
package com.eventzone.cosc412.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eventzone.cosc412.model.UserInfo;

/**
 * @author sheilan89
 *
 */
public interface UserInfoDAO extends JpaRepository<UserInfo, Long> {

}
