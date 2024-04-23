package com.lcwd.user.service.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.user.service.Entities.User;
import com.lcwd.user.service.Service.UserService;

@RestController
@RequestMapping("/users")
public class userController {
  
	@Autowired
	private UserService userservice;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		User createUser=userservice.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(createUser);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
	    User user = userservice.getUserById(userId);
	    return ResponseEntity.ok(user);
	}
	
	
	@PutMapping
	public ResponseEntity<User> updateUser(@RequestParam("userId") Long userId,@RequestBody User user){
		User updateUser = userservice.updateUser(userId, user);
        return ResponseEntity.ok(updateUser);
	}
	
	
	@DeleteMapping
	public ResponseEntity<User> deleteUser(@RequestParam("/{userId}") Long userId){
		userservice.deleteUser(userId);
		return ResponseEntity.noContent().build();
	}
}
