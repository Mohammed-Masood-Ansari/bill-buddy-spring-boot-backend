package com.ansari.split_with_room_mates.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ansari.split_with_room_mates.dao.ItemsDao;
import com.ansari.split_with_room_mates.dao.UserDao;
import com.ansari.split_with_room_mates.dto.Items;
import com.ansari.split_with_room_mates.dto.Rooms;
import com.ansari.split_with_room_mates.dto.User;

import jakarta.mail.FetchProfile.Item;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/items")
@AllArgsConstructor
public class ItemsController {

	private ItemsDao itemsDao;
	
	private HttpSession httpSession;
	
	private UserDao userDao;
	
	@PostMapping(value = "/addItems/{roomName}")
	public String saveItemsDao(@RequestBody Items items, @PathVariable(name = "roomName") String roomName) {
		Items items2=itemsDao.saveItemsDao(items,roomName);
		return items2!=null?"items-added":"items-not-added";
	}
	
//	@GetMapping("/groupItems")
//	public ResponseEntity<?> getGroupItemsForLoggedInUser() {
//	    
//		String email = (String) httpSession.getAttribute("userSession");
//
//	    if (email == null) {
//	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//	                .body(Map.of("error", "Authentication required. Please login."));
//	    }
//
//	    // Step 1: Find logged-in user
//	    User loggedInUser = userDao.findByEmailDao(email);
//
//	    if (loggedInUser == null) {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not found"));
//	    }
//
//	    // Step 2: Get the room the user is part of
//	    Rooms room = loggedInUser.getRooms();
//
//	    if (room == null) {
//	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not in any room"));
//	    }
//
//	    // Step 3: Get all users in the room
//	    List<User> users = room.getUsers();
//	    
//	    
//	    List<Integer> roomMembers=users.stream().map(User::getId).toList();
//	    
//
//	    // Step 4: Fetch items by users in this room
//	    List<Item> items = itemsDao.findItemsByRoomAndUsers(room.getId(), roomMembers);
//
//	    return ResponseEntity.ok(Map.of(
//	        "message", "Fetched items for group",
//	        "roomId", room.getId(),
//	        "items", items
//	    ));
//	}

}
