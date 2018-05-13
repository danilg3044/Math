package com.daniel.math;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
@ComponentScan(basePackages = {"com.daniel.math.services", "com.daniel.math.controllers"})
public class MathApp {

	public static void main(String[] args) {
		SpringApplication.run(MathApp.class, args);
	}
}
