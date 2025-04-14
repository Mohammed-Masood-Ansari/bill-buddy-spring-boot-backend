package com.ansari.split_with_room_mates.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	private int id;
	private String name;
	private String email;
	private String password;
	
}
