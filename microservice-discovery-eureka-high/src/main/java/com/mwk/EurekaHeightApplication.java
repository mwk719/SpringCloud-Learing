package com.mwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 高可用
 * 12.3 High Availability, Zones and Regions
 * @author 闵渭凯
 *
 * 2018年7月11日
 */
@SpringBootApplication
@EnableEurekaServer//eureka注册中心配置
public class EurekaHeightApplication 
{
    public static void main( String[] args )
    {
       SpringApplication.run(EurekaHeightApplication.class, args);
    }
}
