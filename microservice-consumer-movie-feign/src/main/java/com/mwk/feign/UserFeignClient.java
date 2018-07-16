package com.mwk.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mwk.entity.User;

@FeignClient("microservice-provider-user-client")
public interface UserFeignClient {
	
	//支持负载均衡
	@RequestMapping(value="/simple/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public User postUser(@RequestBody User user);

}
