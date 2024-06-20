package com.gl.amit.CollageStudentManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gl.amit.CollageStudentManagementSystem.Entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("Select u from User u where u.username = ?1")
	public User getUserByUsername(String username);
}
