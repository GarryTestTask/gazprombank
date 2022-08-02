package com.example.gazprombank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GazprombankApplication {

	public static void main(String[] args) {
		SpringApplication.run(GazprombankApplication.class, args);
	}

}
