package com.test.hotelsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.test.hotelsearch")
public class HotelsearchApplication {
	public static void main(String[] args) {
		SpringApplication.run(HotelsearchApplication.class, args);
	}

}
