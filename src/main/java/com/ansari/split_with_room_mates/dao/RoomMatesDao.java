package com.ansari.split_with_room_mates.dao;

import java.util.List;

import com.ansari.split_with_room_mates.dto.Rooms;

public interface RoomMatesDao {
	
	public Rooms saveRoomMatesDao(Rooms rooms);
	
	public String addRoomMatesDao(String userEmail,String roomName);
	
	Rooms findByroomNameDao(String roomName);
	
}
