package com.ansari.split_with_room_mates.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
	@SequenceGenerator(name = "employee_seq", sequenceName = "employee_sequence", allocationSize = 1, initialValue = 9001)
	private int id;
	private String name;
	private String email;
	private String password;
	
	@ManyToOne
	@JoinColumn(name = "roomid")
	@JsonBackReference  // Prevent infinite recursion when serializing the Rooms relationship
	private Rooms rooms;
	
	@OneToMany(mappedBy = "user")
	@JsonManagedReference 
	private List<Items> items;
}
