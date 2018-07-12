package com.mwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
/**
 * eureka客户端
 * @author 闵渭凯
 *
 * 2018年7月11日
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClient2Application 
{
    public static void main( String[] args )
    {
       SpringApplication.run(EurekaClient2Application.class, args);
    }
}
