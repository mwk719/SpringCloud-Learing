package com.mwk;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
/**
 * Ribbon负载均衡策略配置
 * @author 闵渭凯
 *
 * 2018年7月12日
 */
@Configuration
@ExcludeFromComponentScan//排除组件扫描,不加会被所有的@RibbonClient共享
public class TestConfiguration {

	/**
	 * 在index上随机，选择index对应位置的server
	 * @return
	 */
	@Bean
	public IRule ribbonRule() {
		return new RandomRule();
	}
}
