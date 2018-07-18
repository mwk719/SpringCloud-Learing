package com.mwk.feign;

import org.springframework.stereotype.Component;

import com.mwk.entity.User;

import feign.hystrix.FallbackFactory;

/**
 * 如果需要访问导致回退触发器的原因，可以使用@FeignClient中的fallbackFactory属性。
 * @author 闵渭凯
 *
 * 2018年7月18日
 */
@Component
public class HystrixClientFallbackFactory implements FallbackFactory<UserFeignClient> {

	//private static final Logger LOGGER=LoggerFactory.getLogger(HystrixClientFallbackFactory.class);
	
	@Override
	public UserFeignClient create(Throwable arg0) {
		
		//LOGGER.info("-异常捕捉--fallback; reason was: " + arg0.getMessage());
		return new HystrixClient() {
			@Override
			public User findById(Long id) {
				User u=new User();
				u.setId(-1L);
				return u;
			}
		};
	}

}
