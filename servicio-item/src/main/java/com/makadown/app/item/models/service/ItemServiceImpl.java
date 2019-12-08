package com.makadown.app.item.models.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.HashMap;

import com.makadown.app.item.models.Item;
import com.makadown.app.item.models.Producto;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		List<Producto> productos = Arrays.asList( clienteRest.getForObject("http://localhost:8001/listar", Producto[].class));
		/* Gracias a JDK 1.8 convierto la lista de productos en un flujo y usar el map para cambiar cada elemento del flujo y
		 * generar en lista un Item a partir de cada objeto Producto */
		return productos.stream().map( p -> new Item(p, 1) ).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		Map<String, String> pathVariables = new HashMap<String, String>();
		pathVariables.put("id", id.toString());
		Producto producto = clienteRest.getForObject("http://localhost:8001/ver/{id}", Producto.class, pathVariables);
		return new Item(producto, cantidad);
	}

}
