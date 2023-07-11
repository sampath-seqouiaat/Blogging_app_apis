package com.sampath.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sampath.blog.playloads.UserDto;
@Service
public interface UserService {

	UserDto creatUser(UserDto userdto);
	
	UserDto updateUser(UserDto user,Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUser();
	 
	void deletUser(Integer userId);
	
}
