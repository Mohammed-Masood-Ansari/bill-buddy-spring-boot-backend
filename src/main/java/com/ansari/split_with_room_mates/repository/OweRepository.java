package com.ansari.split_with_room_mates.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ansari.split_with_room_mates.dto.Owe;
import com.ansari.split_with_room_mates.dto.User;

public interface OweRepository extends JpaRepository<Owe, Integer> {

	Owe findByBorrowUserId(int userId);

	// Check for an owe relationship between two users (payer -> borrower)
	Optional<Owe> findByUserAndBorrowUserId(User user, int borrowUserId);

	// Check for an owe relationship from the reverse (borrower -> payer)
	Optional<Owe> findByBorrowUserIdAndUserId(int borrowerId, int userId);
	
	
	@Query(value = "SELECT * FROM owemoney WHERE borrowed_userid = :userId OR lent_userid = :userId", nativeQuery = true)
	Optional<Owe> findByBorrowOrLendUser(@Param("userId") int userId);

}
