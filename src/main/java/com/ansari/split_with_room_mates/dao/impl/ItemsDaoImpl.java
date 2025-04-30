package com.ansari.split_with_room_mates.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ansari.split_with_room_mates.dao.ItemsDao;
import com.ansari.split_with_room_mates.dao.OweRepository;
import com.ansari.split_with_room_mates.dao.UserDao;
import com.ansari.split_with_room_mates.dto.Items;
import com.ansari.split_with_room_mates.dto.Owe;
import com.ansari.split_with_room_mates.dto.Rooms;
import com.ansari.split_with_room_mates.dto.User;
import com.ansari.split_with_room_mates.repository.ItemsRepository;
import com.ansari.split_with_room_mates.repository.RoomsRepository;

import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
public class ItemsDaoImpl implements ItemsDao {

	private ItemsRepository itemsRepository;

	private UserDao userDao;

	private HttpSession httpSession;

	private RoomsRepository roomsRepository;

	private OweRepository oweRepository;

	private Owe owe;

	@Override
	public Items saveItemsDao(Items items, String roomName) {

		String email = (String) httpSession.getAttribute("userSession");

		User user = userDao.findByEmailDao(email);

		Rooms rooms = roomsRepository.findByRoomName(roomName);

		List<User> users = rooms.getUsers();

		long userCount = users.stream().count();

		double price = items.getPrice() / userCount;

		System.out.println(price);

		items.setRooms(rooms);

		items.setUser(user);

		for (User user2 : users) {
			Owe owe1 = new Owe();
			if (user2.getId() != user.getId()) {

				Owe owe = oweRepository.findByBorrowUserId(user2.getId());

				if (owe != null) {
					
					owe.setLendmoney(price + owe.getLendmoney());
					owe.setUser(user);
					owe.setBorrowUserId(user2.getId());

					oweRepository.save(owe);
				} else  {
					owe1.setLendmoney(price);
					owe1.setUser(user);
					owe1.setBorrowUserId(user2.getId());

					oweRepository.save(owe1);
				}
			}else {
				System.out.println("present");
			}
		}

		System.out.println(userCount);

		return itemsRepository.save(items);
	}

}
