package com.makadown.app.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.makadown.app.item.models.Producto;

/***
 * Clase que implementa cliente Feign (REST) para consumir APIs
 * @author makadown
 *
 */
@FeignClient(name="servicio-productos", url="localhost:8001")
public interface ProductoClienteRest {
	
	@GetMapping("/listar")
	public List<Producto> listar();
	
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id);
}
