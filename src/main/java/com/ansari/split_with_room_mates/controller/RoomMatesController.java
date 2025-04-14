package com.ansari.split_with_room_mates.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ansari.split_with_room_mates.dao.RoomMatesDao;
import com.ansari.split_with_room_mates.dto.Rooms;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/roomMates")
@AllArgsConstructor
public class RoomMatesController {

	private RoomMatesDao matesDao;

	@PostMapping(value = "/createRoom")
	public Rooms saveRoomMatesController(@RequestBody Rooms rooms) {
		return matesDao.saveRoomMatesDao(rooms);
	}

	@GetMapping(value = "/addRoomMates/{userEmail}/{roomName}")
	public String addRoomMatesController(@PathVariable(name = "userEmail") String userEmail,
			@PathVariable(name = "roomName") String roomName) {
		return matesDao.addRoomMatesDao(userEmail, roomName);
	}
}
