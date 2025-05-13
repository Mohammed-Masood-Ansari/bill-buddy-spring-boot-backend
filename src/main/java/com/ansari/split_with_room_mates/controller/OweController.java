package com.ansari.split_with_room_mates.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ansari.split_with_room_mates.dao.OweDao;
import com.ansari.split_with_room_mates.dao.UserDao;
import com.ansari.split_with_room_mates.dto.Owe;
import com.ansari.split_with_room_mates.dto.User;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/owe")
@CrossOrigin(value = "http://localhost:5173")
public class OweController {

	@Autowired
	private OweDao oweDao;

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private HttpSession httpSession;

	
	@GetMapping(value = "/getOweUserByLoggedUserId")
	public ResponseEntity<?> findByUserIdController() {

		System.out.println("execution started!!!!!");
		
		String email = (String) httpSession.getAttribute("userSession");

		if (email == null) {
			System.out.println("first login !!!!!");
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
					.body(Map.of("error", "Authentication required. Please login."));
		}

		// Step 1: Find logged-in user
		User loggedInUser = userDao.findByEmailDao(email);

		if (loggedInUser == null) {
			System.out.println("user is not found!!!!!");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not found"));
		}

		Owe  owe = oweDao.findByUserIdDao(loggedInUser.getId());

		if(owe==null) {
			System.out.println("owe table data not avaialbe");
			return ResponseEntity.status(HttpStatus.NO_CONTENT)
					.body(Map.of("message", "No One Borrow Money"));
		}
		
		User borrowUser = userDao.findByUserIdDao(owe.getBorrowUserId());
		
		User lentUser = userDao.findByUserIdDao(owe.getUser().getId());
		
		System.out.println(lentUser.getName());
		
		return ResponseEntity.status(HttpStatus.OK)
				.body(Map.of("borrowMessage", borrowUser.getName()+" borrow ","money",owe.getLendmoney(),"lendMessage"," from "+lentUser.getName()));
	}
}
