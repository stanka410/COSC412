package com.eventzone.cosc412.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eventzone.cosc412.model.UserInfo;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<UserInfo, Long> {
	 UserInfo findByEmail(String email);

	UserInfo findUserByUserInfoId(Long userInfoId);
}
