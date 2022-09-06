package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.Categoria;
import com.issler.patrick.QoSystem.entity.Item;
import com.issler.patrick.QoSystem.service.ItemService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ResponseEntity<?> GetById(@RequestBody Item item) {
		return service.buscar(item);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Item item) {
		return service.save(item);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Item item) {
		return service.delete(item);
	}

	@RequestMapping(value = "/buscar/categoria", method = RequestMethod.GET)
	public ResponseEntity<?> FindALL(@RequestBody Categoria categoria) {
		return service.findAllByCategoria(categoria);
	}

}