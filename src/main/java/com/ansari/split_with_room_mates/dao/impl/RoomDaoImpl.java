package com.ansari.split_with_room_mates.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ansari.split_with_room_mates.dao.RoomDao;
import com.ansari.split_with_room_mates.dto.Rooms;
import com.ansari.split_with_room_mates.repository.RoomsRepository;

@Repository
public class RoomDaoImpl implements RoomDao {

	@Autowired
	private RoomsRepository roomsRepository;

	@Override
	public List<Rooms> getAllRoomsDao() {

		return roomsRepository.findAll();
	}

	@Override
	public List<Rooms> findRoomsByUserId(int userId) {
		
		List<Rooms> allRooms = getAllRoomsDao();

		return allRooms.stream().filter(room -> room.getUsers().stream().anyMatch(user -> user.getId() == userId))
				.collect(Collectors.toList());
	}

}
