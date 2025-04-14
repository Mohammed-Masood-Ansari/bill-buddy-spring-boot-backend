package com.ansari.split_with_room_mates.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ansari.split_with_room_mates.dao.UserDao;
import com.ansari.split_with_room_mates.dto.User;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@RestController
@CrossOrigin(value = "http://localhost:5173")
@RequestMapping(value = "/user")
@AllArgsConstructor
public class UserController {

	private UserDao userDao;

	private HttpSession httpSession;

	/**
	 * this api is use for user registration
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping(value = "/saveUser")
	public User saveUserController(@RequestBody User user) {
		return userDao.saveUserDao(user);
	}

	@GetMapping(value = "/loginUser/{userEmail}/{userPass}")
	public User loginWithUserController(@PathVariable(name = "userEmail") String userEmail,
			@PathVariable(name = "userPass") String userPass) {
		
		User user = userDao.findByEmailDao(userEmail);

		if (user != null) {
			if (user.getPassword().equals(userPass)) {
				httpSession.setAttribute("userSession", user.getEmail());
				return user;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
