package com.makadown.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.makadown.app.productos.models.entity.Producto;

/***
 * Interface para Productos.
 * Nota: Esta claro que las interfaces no llevan implementación. Son un protocolo de métodos de comportamiento que tienen que implementar algunas clases para
 * cumplir con dicho contrato.
 * @author makadown
 */
public interface ProductoDao extends CrudRepository<Producto, Long>{
	
}
