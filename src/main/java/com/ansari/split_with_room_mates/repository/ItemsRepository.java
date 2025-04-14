package com.ansari.split_with_room_mates.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ansari.split_with_room_mates.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {

	
}
