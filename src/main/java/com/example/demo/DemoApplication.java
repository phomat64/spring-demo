package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableCaching
@ComponentScan(basePackages = {"com.example.demo"})
//@EnableAutoConfiguration(exclude = {
//        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
//        org.springframework.boot.actuate.autoconfigure.ManagementWebSecurityAutoConfiguration.class})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
