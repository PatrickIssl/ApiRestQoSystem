package com.issler.patrick.QoSystem.service;

import com.issler.patrick.QoSystem.entity.Categoria;
import com.issler.patrick.QoSystem.entity.Ingrediente;
import com.issler.patrick.QoSystem.entity.Item;
import com.issler.patrick.QoSystem.entity.PedidoItem;
import com.issler.patrick.QoSystem.repository.CategoriaRepository;
import com.issler.patrick.QoSystem.repository.IngredienteRepository;
import com.issler.patrick.QoSystem.repository.ItemRepository;
import com.issler.patrick.QoSystem.repository.PedidoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
			item.get().setCategoria(null);
			itemRepository.delete(item.get());
			return new ResponseEntity<>("Item deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Item não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Item item) {
		Optional<Item> items = itemRepository.findById(item.getId());
		if (items.isPresent()) {
			List<Ingrediente> listaIngredientes = new ArrayList<>();
			if(!items.get().getIngredientes().isEmpty()){
				for(Ingrediente ingrediente: items.get().getIngredientes()){
					ingrediente.setItems(null);
					listaIngredientes.add(ingrediente);
				}
			}
			items.get().setIngredientes(listaIngredientes);
			return new ResponseEntity<Item>(items.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Item não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Item items) {
		List<Ingrediente> ingredientes = new ArrayList<>();

		List<Ingrediente> managedItens = items.getIngredientes();
		for(Ingrediente ingrediente : managedItens){
			Optional<Ingrediente> ingredienteBusca = ingredienteRepository.findById(ingrediente.getId());
			ingredienteBusca.ifPresent(ingredientes::add);
		}

		List<PedidoItem> pedidoItems = new ArrayList<>();
		if(items.getPedidoItems() != null){
			for(PedidoItem pedidoitem : items.getPedidoItems()){
				Optional<PedidoItem> pedidoItemBusca = pedidoItemRepository.findById(pedidoitem.getId());
				pedidoItemBusca.ifPresent(pedidoItems::add);
			}
		}
		Optional<Categoria> categoriaBusca = categoriaRepository.findById(items.getCategoria().getId());
		categoriaBusca.ifPresent(items::setCategoria);
		items.setPedidoItems(pedidoItems);
		items.setIngredientes(ingredientes);
		for (Ingrediente ingrediente: ingredientes){
			ingrediente.getItems().add(items);
		}

		itemRepository.save(items);
		if(items.getIngredientes() != null){
			List<Ingrediente> ingredientesLista = new ArrayList<>();
			for(Ingrediente ingredienteObj :items.getIngredientes()){
				ingredienteObj.setItems(null);
				ingredientesLista.add(ingredienteObj);
			}
			items.setIngredientes(ingredientesLista);
		}
		return new ResponseEntity<Item>(items, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		List<Item> item = itemRepository.findAll();
		if (!item.isEmpty()) {
			if (!item.isEmpty()) {
				List<Item> listaitems = new ArrayList<>();
				for (Item itemFor : item) {
					if (itemFor.getIngredientes() != null) {
						List<Ingrediente> listaIngredientes = new ArrayList<>();
						for (Ingrediente ingredite : itemFor.getIngredientes()) {
							ingredite.setItems(null);
							listaIngredientes.add(ingredite);
						}
						itemFor.setIngredientes(listaIngredientes);
						listaitems.add(itemFor);
					}
				}
				return new ResponseEntity<>(listaitems, HttpStatus.OK);
			}
		}
			return new ResponseEntity<>("vazio", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> findAllByCategoria(Categoria categoria) {
		List<Item> item = itemRepository.findAllByCategoria(categoria);
		if (!item.isEmpty()) {
			if(!item.isEmpty()){
				List<Item> listaitems = new ArrayList<>();
				for (Item itemFor: item){
					if (itemFor.getIngredientes() != null){
						List<Ingrediente> listaIngredientes = new ArrayList<>();
						for (Ingrediente ingredite: itemFor.getIngredientes()){
							ingredite.setItems(null);
							listaIngredientes.add(ingredite);
						}
						itemFor.setIngredientes(listaIngredientes);
						listaitems.add(itemFor);
					}
				}
				return new ResponseEntity<>(listaitems, HttpStatus.OK);
			}
			return new ResponseEntity<>(item, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Lista de items vazio para essa categoria", HttpStatus.NOT_FOUND);
		}
	}

}
