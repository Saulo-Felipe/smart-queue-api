package com.queue.api.smartqueueapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartQueueApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartQueueApiApplication.class, args);
		for (int c = 0; c < 10; c++) {
			System.out.println("\n");
		}
	}

}
