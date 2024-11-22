package com.mario.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;

import org.springframework.web.reactive.function.client.WebClient;

import com.mario.springcloud.msvc.items.models.Item;

public class ProductServiceWebClient implements ItemService {
    private final WebClient.Builder client;

    public ProductServiceWebClient(WebClient.Builder client) {
        this.client = client;
    }

    @Override
    public List<Item> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public Optional<Item> findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

}
