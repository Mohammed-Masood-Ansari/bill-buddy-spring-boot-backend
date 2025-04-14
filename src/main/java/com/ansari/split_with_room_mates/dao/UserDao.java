package com.ansari.split_with_room_mates.dao;

import com.ansari.split_with_room_mates.dto.User;

public interface UserDao {

	public User saveUserDao(User user);
	
	public User findByEmailDao(String userEmail);
	
}
