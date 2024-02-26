package com.backend.grupo1.rentacar;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentacarApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger
			(RentacarApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RentacarApplication.class, args);
		LOGGER.info("RentacarApplication is now running...");
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
