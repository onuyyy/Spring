package com.sist.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@ComponentScan(basePackages= {"com.sist.web.controller",
		"com.sist.web.service","com.sist.web.dao"})
public class SpringBootDataBaseProjecttApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataBaseProjecttApplication.class, args);
	}

}
