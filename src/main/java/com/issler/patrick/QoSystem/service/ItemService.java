package com.issler.patrick.QoSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.issler.patrick.QoSystem.entity.Ingrediente;
import com.issler.patrick.QoSystem.entity.PedidoItem;
import com.issler.patrick.QoSystem.repository.CategoriaRepository;
import com.issler.patrick.QoSystem.repository.IngredienteRepository;
import com.issler.patrick.QoSystem.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Categoria;
import com.issler.patrick.QoSystem.entity.Item;
import com.issler.patrick.QoSystem.repository.ItemRepository;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@Service
public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	PedidoItemRepository pedidoItemRepository;
	@Autowired
	IngredienteRepository ingredienteRepository;

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
		List<Ingrediente> ingredientes = new ArrayList<>();
		for(Ingrediente ingrediente :items.getIngredientes()){
			ingredientes.add(ingredienteRepository.findById(ingrediente.getId()).get());
		}

		List<PedidoItem> pedidoItems = new ArrayList<>();
		for(PedidoItem pedidoitem :items.getPedidoItems()){
			pedidoItems.add(pedidoItemRepository.findById(pedidoitem.getId()).get());
		}
		items.setPedidoItems(pedidoItems);
		items.setIngredientes(ingredientes);
		items.setCategoria(categoriaRepository.findById(items.getCategoria().getId())
				.get());
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
