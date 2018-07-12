package com.mwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 
 * @author 闵渭凯
 *
 * 2018年7月11日
 */
@SpringBootApplication
@EnableEurekaServer//eureka注册中心配置
public class EurekaApplication 
{
    public static void main( String[] args )
    {
       SpringApplication.run(EurekaApplication.class, args);
    }
}
