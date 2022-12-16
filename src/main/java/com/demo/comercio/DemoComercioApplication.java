package com.demo.comercio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
public class DemoComercioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoComercioApplication.class, args);
	}

}
