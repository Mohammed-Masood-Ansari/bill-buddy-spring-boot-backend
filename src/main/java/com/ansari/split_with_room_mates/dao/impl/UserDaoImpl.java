package com.ansari.split_with_room_mates.dao.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ansari.split_with_room_mates.dao.UserDao;
import com.ansari.split_with_room_mates.dto.User;
import com.ansari.split_with_room_mates.repository.UserRepository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class UserDaoImpl implements UserDao {

	private UserRepository repository;
	
	@Override
	public User saveUserDao(User user) {
		return repository.save(user);
	}

	@Override
	public User findByEmailDao(String userEmail) {
		Optional<User> user=repository.findByEmail(userEmail);
		return user.isPresent()?user.get():null;
	}

}
