package com.technical.userapp;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootTest
@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(
		type = FilterType.ASSIGNABLE_TYPE,
		value = {UserAppApplication.class}))
public class UserAppApplicationTests {

	public static void main(String[] args) {
		SpringApplication.run(UserAppApplicationTests.class, args);
	}

	@Test
	void contextLoads() {
	}

}


