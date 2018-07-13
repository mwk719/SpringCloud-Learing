package com.mwk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mwk.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private LoadBalancerClient loadBalancerClient;


	@GetMapping("movie/{id}")
	public User findById(@PathVariable Long id) {
		//获取某服务id的信息
		ServiceInstance serviceInstance=this.loadBalancerClient.choose("microservice-provider-user-client");
		System.out.println("负载均衡信息："+serviceInstance.getServiceId()+":"+serviceInstance.getHost()+":"+serviceInstance.getPort());
		return this.restTemplate.getForObject("http://microservice-provider-user-client/simple/" + id, User.class);
	}

	
}
