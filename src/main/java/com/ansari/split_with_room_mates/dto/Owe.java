package com.ansari.split_with_room_mates.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
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

@Entity(name = "owemoney")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Owe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "borrowed_userid")
	private int borrowUserId;
	private double lendmoney;
	
	@ManyToOne
	@JoinColumn(name = "lent_userid")
	private User user;

}
