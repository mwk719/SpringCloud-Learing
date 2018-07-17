package com.mwk.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mwk.entity.User;

@RestController
public class MovieController {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@GetMapping("movie/{id}")
	public User findById(@PathVariable Long id) {
		return this.restTemplate.getForObject("http://microservice-provider-user-client/simple/" + id, User.class);
	}

	/**
	 * 负载均衡
	 * 
	 * @return
	 */
	@GetMapping("/test")
	public String test() {
		ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user-client");
		System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":"
				+ serviceInstance.getPort());

		ServiceInstance serviceInstance2 = this.loadBalancerClient.choose("microservice-provider-user-client2");
		System.out.println("222" + ":" + serviceInstance2.getServiceId() + ":" + serviceInstance2.getHost() + ":"
				+ serviceInstance2.getPort());

		return "1";
	}

	@SuppressWarnings("unchecked")
	@GetMapping("/list-all")
	public Object listAll() {
		JSONArray ja = this.restTemplate.getForObject("http://microservice-provider-user-client/list-all",
				JSONArray.class);
		Map<Object,Object> map=new HashMap<>();
		for (int i = 0; i < ja.size(); i++) {
			//JSONObject jo=JSONObject.parseObject((String) ja.get(i));
			map=(Map<Object, Object>) ja.get(i);
			System.out.println("id:"+map.get("id")+";username:"+map.get("username"));
			//System.out.println(i+"---"+ja.get(i));
		}

		return ja;
	}

}
