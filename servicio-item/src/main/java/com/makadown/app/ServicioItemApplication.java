package com.makadown.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServicioItemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServicioItemApplication.class, args);
	}

}
