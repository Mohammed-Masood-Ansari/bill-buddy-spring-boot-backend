package com.ansari.split_with_room_mates.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ansari.split_with_room_mates.dao.RoomDao;
import com.ansari.split_with_room_mates.dao.RoomMatesDao;
import com.ansari.split_with_room_mates.dto.Rooms;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/roomMates")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173") 
public class RoomMatesController {

	private RoomMatesDao matesDao;
	
	private RoomDao roomDao;

	@PostMapping(value = "/createRoom")
	public Rooms saveRoomMatesController(@RequestBody Rooms rooms) {
		System.out.println("create room api is called");
		return matesDao.saveRoomMatesDao(rooms);
	}
	
	@GetMapping(value = "/getAllRoomDetails")
	public List<Rooms> saveRoomMatesController() {
		System.out.println("get All room api called");
		List<Rooms> rooms=roomDao.getAllRoomsDao();
		
		System.out.println(rooms);
		
		return rooms;
	}

	@GetMapping(value = "/addRoomMates/{userEmail}/{roomName}")
	public String addRoomMatesController(@PathVariable(name = "userEmail") String userEmail,
			@PathVariable(name = "roomName") String roomName) {
		return matesDao.addRoomMatesDao(userEmail, roomName);
	}
}
