package com.makadown.app.item.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.makadown.app.clientes.ProductoClienteRest;
import com.makadown.app.item.models.Item;

/***
 * Implementación principal del Servicio ItemService.
 * 
 * @author makadown
 *
 */
@Service("itemServiceFeign")
// @Primary  Con @Primary se indica a Spring que esta es la clase por defecto a inyectar
public class ItemServiceFeign implements ItemService {
	
	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		return clienteFeign.listar().stream().map( p -> new Item(p, 1) ).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		return new Item(clienteFeign.detalle(id), cantidad) ;
	}

}
