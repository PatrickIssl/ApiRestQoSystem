package com.issler.patrick.QoSystem.service;

import java.util.List;
import java.util.Optional;

import com.issler.patrick.QoSystem.entity.*;
import com.issler.patrick.QoSystem.repository.ItemRepository;
import com.issler.patrick.QoSystem.repository.MesaRepository;
import com.issler.patrick.QoSystem.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.repository.PedidoItemRepository;

import javax.swing.text.html.Option;

@Service
public class PedidoItemService {

	@Autowired
	PedidoItemRepository pedidoITemRepository;

	@Autowired
	MesaRepository mesaRepository;

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	ItemRepository itemRepository;

	public ResponseEntity<String> delete(PedidoItem pedidoITems) {
		Optional<PedidoItem> pedidoITem = pedidoITemRepository.findById(pedidoITems.getId());
		if (pedidoITem.isPresent()) {
			pedidoITemRepository.delete(pedidoITem.get());
			return new ResponseEntity<>("PedidoItem deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PedidoItem não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(PedidoItem pedidoITem) {
		Optional<PedidoItem> pedidoITems = pedidoITemRepository.findById(pedidoITem.getId());
		if (pedidoITems.isPresent()) {
			return new ResponseEntity<PedidoItem>(pedidoITems.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PedidoItem não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> findAllByMesa(PedidoItem pedidoITem) {
		Optional<Mesa> mesa = mesaRepository.findById(pedidoITem.getPedido().getMesa().getId());
		if(!mesa.isPresent()){
			return new ResponseEntity<>("mesa não encontrada", HttpStatus.NOT_FOUND);
		}
		List<PedidoItem> pedidoITems = pedidoITemRepository.findAllByPedidoMesa(mesa.get());
		if (!pedidoITems.isEmpty()) {
			return new ResponseEntity<List<PedidoItem>>(pedidoITems, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("PedidoItem não encontrado", HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<?> put(PedidoItem pedidoItems) {
		Optional<PedidoItem> pedidoItem = pedidoITemRepository.findById(pedidoItems.getId());
		if (pedidoItem != null) {
			pedidoITemRepository.save(pedidoItems);
			return new ResponseEntity<PedidoItem>(pedidoItems, HttpStatus.OK);
		}
		return new ResponseEntity<>("PedidoItem não encontrado", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> save(PedidoItem pedidoITems) {
		Optional<Item> item = itemRepository.findById(pedidoITems.getItem().getId());
		Optional<Pedido> pedido = pedidoRepository.findById(pedidoITems.getPedido().getId());
		if (item.isPresent() && pedido.isPresent()){
			pedidoITems.setPedido(pedido.get());
			pedidoITems.setItem(item.get());
			pedidoITemRepository.save(pedidoITems);
			return new ResponseEntity<PedidoItem>(pedidoITems, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Erro ao encontrar pedido/item", HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(pedidoITemRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<?> findAllByPedido(Pedido pedido) {
		Optional<Pedido> pedidos = pedidoRepository.findById(pedido.getId());
		if(pedidos.isPresent()){
			Optional<List<PedidoItem>> pedidoItem = pedidoITemRepository.getAllByPedido(pedidos);
			return new ResponseEntity<>(pedidoItem, HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Pedido não encontrado", HttpStatus.NOT_FOUND);
		}
	}
}
