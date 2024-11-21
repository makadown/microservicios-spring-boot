package com.mario.springcloud.msvc.items.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mario.springcloud.msvc.items.models.Product;

@FeignClient(url="localhost:8001")
public interface ProductFeignClient {
    
    @GetMapping
    List<Product> findAll();

    @GetMapping("/{id}")
    public Product details(@PathVariable Long id);

}
