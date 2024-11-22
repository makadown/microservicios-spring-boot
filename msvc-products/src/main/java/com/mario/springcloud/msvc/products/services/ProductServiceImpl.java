package com.mario.springcloud.msvc.products.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.core.env.Environment;
// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mario.springcloud.msvc.products.entities.Product;
import com.mario.springcloud.msvc.products.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    final private ProductRepository productRepository;
    final private Environment env;

    public ProductServiceImpl(ProductRepository productRepository, Environment env) {
        this.productRepository = productRepository;
        this.env=env;        
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return ((List<Product>)productRepository.findAll())
                    .stream()
                    .map(product -> {
                        String puerto = env.getProperty("local.server.port");
                        product.setPort( Integer.parseInt(
                             puerto ) );
                        return product;
                    }).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id).map(product -> {
            String puerto = env.getProperty("local.server.port");
            product.setPort( Integer.parseInt( puerto ) );
            return product;
        });
    }
    
}
