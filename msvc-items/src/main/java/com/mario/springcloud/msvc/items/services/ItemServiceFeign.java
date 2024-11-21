package com.mario.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mario.springcloud.msvc.items.clients.ProductFeignClient;
import com.mario.springcloud.msvc.items.models.Item;
import com.mario.springcloud.msvc.items.models.Product;

@Service
public class ItemServiceFeign implements ItemService {
    private final Random rand = new Random();
    /*
    @Autowired
    private ProductFeignClient client;
*/
    final ProductFeignClient client;

    public ItemServiceFeign(ProductFeignClient client) {
        this.client = client;
    }


    @Override
    public List<Item> findAll() {
        return client.findAll().stream()
                .map(p -> {
                    int quantity = rand.nextInt(100)+1;
                    return new Item(p, quantity);
                }).collect(Collectors.toList());
    }

    @Override
    public Optional<Item> findById(Long id) {
        Product product = client.details(id);
        
        if (product == null) {
            return Optional.empty();
        }
        
        return Optional.of(
             new Item(product, rand.nextInt(100)+1)
             ); 
    }

}
