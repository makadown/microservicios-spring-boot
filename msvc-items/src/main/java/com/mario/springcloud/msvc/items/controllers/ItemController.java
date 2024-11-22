package com.mario.springcloud.msvc.items.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.mario.springcloud.msvc.items.models.Item;
import com.mario.springcloud.msvc.items.services.ItemService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class ItemController {

    private final ItemService service;

    public ItemController(ItemService itemService) {
        this.service = itemService;
    }

    @GetMapping
    public List<Item> list() {
        return service.findAll();
    }
    
    @GetMapping("/{id}")
    // public ResponseEntity<Item> details(@PathVariable Long id) {
    public ResponseEntity<?> details(@PathVariable Long id) {
        Optional<Item> itemOptional = service.findById(id);
        if (itemOptional.isPresent()) {
            return ResponseEntity.ok(itemOptional.get());
        }
        return ResponseEntity.status(404)
                .body(Collections.singletonMap("message", "Item not found"));
    }
}
