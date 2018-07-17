package com.mwk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mwk.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("movie/{id}")
	@HystrixCommand(fallbackMethod="findByIdFallback")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://microservice-provider-user-client/simple/" + id, User.class);
	}

	/**
	 * 回滚方法
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unused")
	private User findByIdFallback(Long id) {
		User u=new User();
		u.setId(0L);
		u.setUsername("回滚");
		return u;
	}
}
