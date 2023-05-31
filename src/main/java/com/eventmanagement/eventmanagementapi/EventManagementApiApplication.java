package com.eventmanagement.eventmanagementapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.convert.Jsr310Converters;

@SpringBootApplication
@EntityScan(basePackageClasses = {EventManagementApiApplication.class, Jsr310Converters.class})
public class EventManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventManagementApiApplication.class, args);
	}

}
