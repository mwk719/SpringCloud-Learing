package com.mwk.feign;


import org.springframework.stereotype.Component;

import com.mwk.entity.User;

@Component
public class HystrixClientFallback2 implements UserFeignClient2 {

	@Override
	public User findById(Long id) {
		User u = new User();
		u.setId(2L);
		u.setUsername("feign回滚---2");
		return u;
	}
	
}