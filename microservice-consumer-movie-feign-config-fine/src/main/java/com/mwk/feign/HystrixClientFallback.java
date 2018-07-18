package com.mwk.feign;

import org.springframework.stereotype.Component;

import com.mwk.entity.User;

@Component
public class HystrixClientFallback implements UserFeignClient {

	@Override
	public User findById(Long id) {
		User u = new User();
		u.setId(0L);
		u.setUsername("feign回滚");
		return u;
	}
}