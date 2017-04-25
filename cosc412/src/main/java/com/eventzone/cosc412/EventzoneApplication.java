package com.eventzone.cosc412;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class EventzoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventzoneApplication.class, args);
	}

}
