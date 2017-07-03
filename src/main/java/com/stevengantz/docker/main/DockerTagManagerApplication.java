package com.stevengantz.docker.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.stevengantz")
public class DockerTagManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DockerTagManagerApplication.class, args);
	}
}
