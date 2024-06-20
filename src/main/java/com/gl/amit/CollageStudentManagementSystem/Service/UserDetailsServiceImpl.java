package com.gl.amit.CollageStudentManagementSystem.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.amit.CollageStudentManagementSystem.Entity.User;
import com.gl.amit.CollageStudentManagementSystem.Repository.UserRepository;
import com.gl.amit.CollageStudentManagementSystem.Security.MyUserDetails;


public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUsername(username);
		
		if(user==null) {
			throw new UsernameNotFoundException("Could not find user");
		}
		return new MyUserDetails(user);
	}
}
