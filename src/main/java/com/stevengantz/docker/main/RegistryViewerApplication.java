package com.stevengantz.docker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.stevengantz")
public class RegistryViewerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryViewerApplication.class, args);
	}
}
