package com.mwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class MovieFeignHystrixFactoryApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(MovieFeignHystrixFactoryApplication.class, args);
    }
}
