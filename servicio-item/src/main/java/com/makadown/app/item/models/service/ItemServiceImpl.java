package com.makadown.app.item.models.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.HashMap;

import com.makadown.app.item.models.Item;
import com.makadown.app.item.models.Producto;

/***
 * Implementación secundaria del Servicio ItemService.
 * @author makadown
 *
 */
@Service("itemServiceRestTemplate")
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		/* Gracias a @LoadBalanced en AppConfig se detecta la ubicacion del servicio */
		List<Producto> productos = Arrays.asList( clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));
		/* Gracias a JDK 1.8 convierto la lista de productos en un flujo y usar el map para cambiar cada elemento del flujo y
		 * generar en lista un Item a partir de cada objeto Producto */
		return productos.stream().map( p -> new Item(p, 1) ).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
