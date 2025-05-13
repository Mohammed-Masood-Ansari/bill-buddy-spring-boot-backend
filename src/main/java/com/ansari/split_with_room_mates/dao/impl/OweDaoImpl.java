package com.ansari.split_with_room_mates.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ansari.split_with_room_mates.dao.OweDao;
import com.ansari.split_with_room_mates.dto.Owe;
import com.ansari.split_with_room_mates.repository.OweRepository;

@Repository
public class OweDaoImpl implements OweDao{
	
	
	@Autowired
	private OweRepository oweRepository;

	@Override
	public Owe findByUserIdDao(int userId) {
		
		Optional<Owe> optional = oweRepository.findByBorrowOrLendUser(userId);
		
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}

	
}
