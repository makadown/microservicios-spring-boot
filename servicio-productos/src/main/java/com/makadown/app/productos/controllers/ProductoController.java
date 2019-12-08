package com.makadown.app.productos.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

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
	
	/*@Autowired
	private Environment env;*/
	
	/***
	 * Atributo para obtener valor de archivo de properties.
	 * OJO: Aqui no se necesita local. al inicio con para la instancia
	 * de Environment
	 */
	@Value("${server.port}")
	private Integer port;
	
	@Autowired
	private IProductoService productoService;
	
	/***
	 * Método para listar productos
	 * @return
	 */
	@GetMapping("/listar")
	public List<Producto> listar(){
		// Itero con lambdas por cada producto para obtener puerto del microservicio
		return productoService.findAll().stream().map(producto -> {
			// producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			producto.setPort(port);
			return producto;
		}).collect(Collectors.toList());
	}
	
	/***
	 * Método para listar 1 producto por Id
	 * @param id
	 * @return
	 */
	@GetMapping("/ver/{id}")
	public Producto detalle(@PathVariable Long id) {
		Producto producto = productoService.findById(id);
		// producto.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		producto.setPort(port);
		return producto;
	}

}
