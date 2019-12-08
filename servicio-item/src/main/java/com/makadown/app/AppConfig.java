package com.makadown.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	
	/***
	 * Método para registrar un cliente para trabajar con un cliente API Rest y
	 * acceder a recursos que están en otros microservicios
	 * @return
	 */
	@Bean("clienteRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
