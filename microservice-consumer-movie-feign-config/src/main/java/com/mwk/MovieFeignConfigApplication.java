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
public class MovieFeignConfigApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(MovieFeignConfigApplication.class, args);
    }
}
