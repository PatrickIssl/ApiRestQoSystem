package com.issler.patrick.QoSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.PedidoItem;
import com.issler.patrick.QoSystem.controller.repository.PedidoItemRepository;

@Service
public class PedidoItemService {

	@Autowired
	PedidoItemRepository pedidoITemRepository;

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

	public ResponseEntity<?> save(PedidoItem pedidoITems) {
		pedidoITemRepository.save(pedidoITems);
		return new ResponseEntity<PedidoItem>(pedidoITems, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(pedidoITemRepository.findAll(), HttpStatus.OK);
	}

}
