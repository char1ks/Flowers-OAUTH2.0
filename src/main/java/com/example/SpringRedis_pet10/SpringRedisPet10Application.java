package com.example.SpringRedis_pet10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SpringRedisPet10Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisPet10Application.class, args);
	}

}
