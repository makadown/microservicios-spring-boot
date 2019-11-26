package com.makadown.app.productos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.makadown.app.productos.models.entity.Producto;
import com.makadown.app.productos.models.service.IProductoService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/***
 * Controlador para producto
 * @author makadown
 */
@RestController
public class ProductoController {
	@Autowired
	private IProductoService productoService;
	
	/***
	 * Método para listar productos
	 * @return
	 */
	@GetMapping("/listar")
	public List<Producto> listar(){
		return productoService.findAll();
	}
	
	/***
	 * Método para listar 1 producto por Id
	 * @param id
	 * @return
	 */
	@GetMapping("/listar/{id}")
	public Producto detalle(@PathVariable Long id) {
		return productoService.findById(id);
	}

}
