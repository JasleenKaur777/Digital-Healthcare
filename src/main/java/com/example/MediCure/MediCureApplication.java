package com.example.MediCure;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MediCureApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediCureApplication.class, args);
	}
	@Bean
	 ModelMapper modelmapper() {
		return new ModelMapper();
	}

}
