package com.makadown.app.productos.models.service;

import java.util.List;

import com.makadown.app.productos.models.entity.Producto;

public interface IProductoService {
	public List<Producto> findAll();
	public Producto findById(Long id);
}
