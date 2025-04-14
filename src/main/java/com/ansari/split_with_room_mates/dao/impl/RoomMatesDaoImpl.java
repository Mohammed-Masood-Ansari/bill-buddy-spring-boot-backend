package com.ansari.split_with_room_mates.dao.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ansari.split_with_room_mates.dao.RoomMatesDao;
import com.ansari.split_with_room_mates.dao.UserDao;
import com.ansari.split_with_room_mates.dto.Rooms;
import com.ansari.split_with_room_mates.dto.User;
import com.ansari.split_with_room_mates.repository.RoomMatesRepository;
import com.ansari.split_with_room_mates.repository.RoomsRepository;

import lombok.AllArgsConstructor;

@SuppressWarnings("unused")
@Repository
@AllArgsConstructor
public class RoomMatesDaoImpl implements RoomMatesDao {

	private RoomMatesRepository roomMatesRepository;
	
	private UserDao userDao;
	
	@Override
	public Rooms saveRoomMatesDao(Rooms roomMates) {
		return roomMatesRepository.save(roomMates);
	}

	@Override
	public String addRoomMatesDao(String userEmail, String roomName) {
		
		User user = userDao.findByEmailDao(userEmail);
		
		Rooms roomMates = findByroomNameDao(roomName);
		
		roomMatesRepository.addRoomMates(roomMates.getId(),user.getId());
		
		return "added";
	}

	@Override
	public Rooms findByroomNameDao(String roomName) {
		return roomMatesRepository.findByroomName(roomName);
	}

}
