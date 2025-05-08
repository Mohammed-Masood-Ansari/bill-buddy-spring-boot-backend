package com.ansari.split_with_room_mates.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ansari.split_with_room_mates.dao.RoomDao;
import com.ansari.split_with_room_mates.dto.Rooms;
import com.ansari.split_with_room_mates.repository.RoomsRepository;

@Repository
public class RoomDaoImpl implements RoomDao{

	@Autowired
	private RoomsRepository repository;
	
	@Override
	public List<Rooms> getAllRoomsDao() {
		
		return repository.findAll();
	}

}
