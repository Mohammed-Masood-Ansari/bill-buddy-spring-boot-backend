package com.ansari.split_with_room_mates.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.split_with_room_mates.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmail(String userEmail);
}
