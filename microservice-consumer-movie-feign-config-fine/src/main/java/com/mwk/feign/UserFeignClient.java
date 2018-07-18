package com.mwk.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mwk.config.configuration;
import com.mwk.entity.User;

@FeignClient(name="microservice-provider-user-client",configuration=configuration.class,fallback=HystrixClientFallback.class)
public interface UserFeignClient {
	
	//支持负载均衡
	@RequestMapping(value="/simple/{id}",method=RequestMethod.GET)
	public User findById(@PathVariable("id") Long id);

}
