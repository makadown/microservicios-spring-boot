package com.makadown.app.item.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.makadown.app.item.models.Item;
import com.makadown.app.item.models.service.ItemService;

@RestController
public class ItemController {

	/***
	 * Interface inyectada de servicio.
	 * El Qualifier es el nombre de servicio implementado
	 */
	@Autowired
	@Qualifier("itemServiceFeign") // @Qualifier("itemServiceRestTemplate") 
	private ItemService itemService;
	
	@GetMapping("/listar")
	public List<Item> listar() {
		return itemService.findAll();
	}
	
	@GetMapping("/ver/{id}/cantidad/{cantidad}")
	public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
		return itemService.findById(id, cantidad);
	}
}
