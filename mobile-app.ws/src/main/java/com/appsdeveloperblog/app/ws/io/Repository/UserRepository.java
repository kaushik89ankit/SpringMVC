package com.appsdeveloperblog.app.ws.io.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appsdeveloperblog.app.ws.io.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByEmail(String email);

	UserEntity findByUserId(String userID);

	@Query(value = "SELECT * FROM USERS WHERE (lastName = ?1 OR firstName = ?2 ) ", nativeQuery = true)
	List<UserEntity> findUserByCustomQuery(String lastName, String firstName);

	@Query(value = "SELECT * FROM USERS WHERE lastName = ?1", nativeQuery = true)
	List<UserEntity> findUserByFirstName(String firstName);
}
