package com.ansari.split_with_room_mates.dao;

import java.util.List;

import com.ansari.split_with_room_mates.dto.Rooms;

public interface RoomDao {

	List<Rooms> getAllRoomsDao();
	
	List<Rooms> findRoomsByUserId(int userId);
}
