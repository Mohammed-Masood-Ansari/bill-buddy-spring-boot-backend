package com.ansari.split_with_room_mates.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.split_with_room_mates.dto.Owe;

public interface OweRepository extends JpaRepository<Owe, Integer> {

	Owe findByBorrowUserId(int userId);
}
