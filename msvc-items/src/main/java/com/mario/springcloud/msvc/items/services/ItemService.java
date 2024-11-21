package com.mario.springcloud.msvc.items.services;

import java.util.List;
import java.util.Optional;

import com.mario.springcloud.msvc.items.models.Item;

public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(Long id);
}
