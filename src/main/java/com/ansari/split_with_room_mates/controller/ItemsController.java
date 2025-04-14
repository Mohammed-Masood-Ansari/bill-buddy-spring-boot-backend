package com.ansari.split_with_room_mates.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ansari.split_with_room_mates.dao.ItemsDao;
import com.ansari.split_with_room_mates.dto.Items;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/items")
@AllArgsConstructor
public class ItemsController {

	private ItemsDao itemsDao;
	
	@PostMapping(value = "/addItems/{roomName}")
	public String saveItemsDao(@RequestBody Items items, @PathVariable(name = "roomName") String roomName) {
		Items items2=itemsDao.saveItemsDao(items,roomName);
		return items2!=null?"items-added":"items-not-added";
	}
}
