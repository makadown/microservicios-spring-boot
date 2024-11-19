package com.mario.springcloud.msvc.products.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mario.springcloud.msvc.products.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
