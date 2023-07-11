package com.sampath.blog.controllers;


import java.util.List;
import com.sampath.blog.playloads.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampath.blog.playloads.UserDto;
import com.sampath.blog.services.UserService;

@RestController
@RequestMapping("api/user")

public class UserController {
 
   @Autowired
   private UserService userService;
	

//create user 
   @PostMapping("/")
   public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
	  UserDto createUserDto = this.userService.creatUser(userDto);
	  return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
}

//put
   @PutMapping("/{userId}")
   public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable("userId") Integer userid){
	  UserDto updateUserDto = this.userService.updateUser(userDto, userid);
	  return ResponseEntity.ok(updateUserDto);
}

   @DeleteMapping("/{userId}")
   public ResponseEntity<Response> deletUser(@PathVariable("userId")Integer userId){
      this.userService.deletUser(userId);
      return new  ResponseEntity(new Response("user not found ",true),HttpStatus.OK);
	
}

   @GetMapping("/")
   public ResponseEntity<List<UserDto>> getAllUser(){
	 return ResponseEntity.ok(this.userService.getAllUser());
	
}
   
   @GetMapping("/{userId}")
   public ResponseEntity<UserDto> getSingleUser(@PathVariable("userId") Integer userId){
	 return ResponseEntity.ok(this.userService.getUserById(userId));
	 
}








}
