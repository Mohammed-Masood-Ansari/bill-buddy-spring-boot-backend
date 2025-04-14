package com.ansari.split_with_room_mates.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String itemsName;
	private double price;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "roomsid")
	private Rooms rooms;
}
