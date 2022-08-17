package com.speakr.dao;

import com.speakr.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {
	
	@Query(value = "SELECT * FROM tbl_user u WHERE u.user_name = \"?1\"", nativeQuery = true )
	User findUserByUserName( String user_name );
	
}
