package com.ansari.split_with_room_mates.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.transaction.annotation.Transactional;

import com.ansari.split_with_room_mates.dto.Rooms;

public interface RoomMatesRepository  extends JpaRepository<Rooms,Integer>{

	Rooms findByroomName(String roomName);
	
	@NativeQuery(value = "insert into rooms_users(rooms_id,users_id) values(?1,?2)")
	@Transactional
	@Modifying
	void addRoomMates(int roomsId,int userId); 
	
}
