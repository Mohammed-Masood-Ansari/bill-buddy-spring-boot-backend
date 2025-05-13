package com.ansari.split_with_room_mates.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;

import com.ansari.split_with_room_mates.dto.Items;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
	
	@NativeQuery(value = "select * from items where roomsid=?1")
	List<Items> findItemsByRoomId(int roomid);
}
