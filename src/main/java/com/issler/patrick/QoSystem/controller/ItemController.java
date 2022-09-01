package com.issler.patrick.QoSystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.Conta;
import com.issler.patrick.QoSystem.entity.Item;
import com.issler.patrick.QoSystem.repository.ItemRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	Conta conta;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public List<Item> Get() {
		return itemRepository.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ResponseEntity<?> GetById(@RequestBody Item item) {
		Optional<Item> items = itemRepository.findById(item.getId());
		if (items.isPresent()) {
			return new ResponseEntity<Item>(items.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Item não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public Item Post(@Valid @RequestBody Item item) {
		return itemRepository.save(item);
	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Item items) {
		Optional<Item> item = itemRepository.findById(items.getId());
		if (item.isPresent()) {
			itemRepository.delete(item.get());
			return new ResponseEntity<>("Item deletado com sucesso", HttpStatus.OK);
		} else
			return new ResponseEntity<>("Item não encontrado", HttpStatus.NOT_FOUND);
	}
}