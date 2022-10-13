package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.issler.patrick.QoSystem.entity.Categoria;
import com.issler.patrick.QoSystem.entity.Item;
import com.issler.patrick.QoSystem.service.ItemService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<?> GetById(@RequestBody Item item) {
		return service.buscar(item);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@RequestBody Item item, @RequestParam("imagem") MultipartFile file) {
		if(file != null){
			try {
				item.setImagem(file.getBytes());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return service.save(item);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@RequestBody Item item) {
		return service.delete(item);
	}

	@RequestMapping(value = "/buscar/categoria", method = RequestMethod.POST)
	public ResponseEntity<?> FindALL(@RequestBody Categoria categoria) {
		return service.findAllByCategoria(categoria);
	}

}