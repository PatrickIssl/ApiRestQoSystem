package com.issler.patrick.QoSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Pedido;
import com.issler.patrick.QoSystem.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	public ResponseEntity<String> delete(Pedido pedidos) {
		Optional<Pedido> pedido = pedidoRepository.findById(pedidos.getId());
		if (pedido.isPresent()) {
			pedidoRepository.delete(pedido.get());
			return new ResponseEntity<>("Pedido deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Pedido não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Pedido pedido) {
		Optional<Pedido> pedidos = pedidoRepository.findById(pedido.getId());
		if (pedidos.isPresent()) {
			return new ResponseEntity<Pedido>(pedidos.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Pedido não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Pedido pedidos) {
		pedidoRepository.save(pedidos);
		return new ResponseEntity<Pedido>(pedidos, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(pedidoRepository.findAll(), HttpStatus.OK);
	}

}
