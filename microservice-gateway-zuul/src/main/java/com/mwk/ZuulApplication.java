package com.mwk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * zuul网关
 * @author 闵渭凯
 *
 * 2018年7月11日
 */
@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication 
{
    public static void main( String[] args )
    {
       SpringApplication.run(ZuulApplication.class, args);
    }
}
