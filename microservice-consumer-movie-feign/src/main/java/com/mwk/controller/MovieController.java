package com.mwk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mwk.entity.User;
import com.mwk.feign.UserFeignClient;

@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		
		return this.userFeignClient.findById(id);
	}
	
	@PostMapping("/movie-user")
	public User postUser(@RequestBody User user) {
		return userFeignClient.postUser(user);
		
	}

}
