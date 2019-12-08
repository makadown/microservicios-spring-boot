package com.makadown.app.item.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.makadown.app.item.models.Item;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		
		return null;
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		
		return null;
	}

}
