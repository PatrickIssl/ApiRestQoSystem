package com.issler.patrick.QoSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Categoria;
import com.issler.patrick.QoSystem.entity.Item;
import com.issler.patrick.QoSystem.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	public ResponseEntity<String> delete(Item items) {
		Optional<Item> item = itemRepository.findById(items.getId());
		if (item.isPresent()) {
			itemRepository.delete(item.get());
			return new ResponseEntity<>("Item deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Item não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Item item) {
		Optional<Item> items = itemRepository.findById(item.getId());
		if (items.isPresent()) {
			return new ResponseEntity<Item>(items.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Item não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Item items) {
		itemRepository.save(items);
		return new ResponseEntity<Item>(items, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(itemRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<?> findAllByCategoria(Categoria categoria) {
		List<Item> item = itemRepository.findAllByCategoria(categoria);
		if (!item.isEmpty()) {
			return new ResponseEntity<>(item, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Lista de items vazio para essa categoria", HttpStatus.NOT_FOUND);
		}
	}

}
