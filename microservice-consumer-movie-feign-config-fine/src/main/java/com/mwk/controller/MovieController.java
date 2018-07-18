package com.mwk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mwk.entity.User;
import com.mwk.feign.UserFeignClient;
import com.mwk.feign.UserFeignClient2;


@RestController
public class MovieController {

	@Autowired
	private UserFeignClient userFeignClient;
	
	@Autowired
	private UserFeignClient2 userFeignClient2;

	@GetMapping("/movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.userFeignClient.findById(id);
	}
	
	@GetMapping("/movie2/{id}")
	public User findById2(@PathVariable Long id) {
		return this.userFeignClient2.findById(id);
	}

}
