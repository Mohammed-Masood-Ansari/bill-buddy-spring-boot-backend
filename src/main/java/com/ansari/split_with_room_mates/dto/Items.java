package com.ansari.split_with_room_mates.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Items {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String itemsName;
	private double price;
	
	@ManyToOne
	@JsonBackReference   // Ignore the user field during serialization
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "roomsid")
	@JsonIgnore  // Ignore the rooms field during serialization
	private Rooms rooms;
}
