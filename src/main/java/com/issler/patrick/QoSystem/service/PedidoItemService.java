package com.issler.patrick.QoSystem.service;

import java.util.List;
import java.util.Optional;

import com.issler.patrick.QoSystem.entity.Mesa;
import com.issler.patrick.QoSystem.repository.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.PedidoItem;
import com.issler.patrick.QoSystem.repository.PedidoItemRepository;

@Service
public class PedidoItemService {

	@Autowired
	PedidoItemRepository pedidoITemRepository;

	@Autowired
	MesaRepository mesaRepository;

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



	public ResponseEntity<?> save(PedidoItem pedidoITems) {
		pedidoITemRepository.save(pedidoITems);
		return new ResponseEntity<PedidoItem>(pedidoITems, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(pedidoITemRepository.findAll(), HttpStatus.OK);
	}

}
