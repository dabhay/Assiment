package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bank.model.User;
import com.bank.model.UserPrimarykey;

@Repository
	public interface UserRepository extends JpaRepository<User, UserPrimarykey> {

		public User findByuserprimarykeyUserIdAndPassword(String userId, String password);

		@Query(value="SELECT count(*) FROM user_details  where user_id=:userId", nativeQuery = true)
		public Integer findByuserprimarykeyUserId(@Param("userId") String userId);

}

