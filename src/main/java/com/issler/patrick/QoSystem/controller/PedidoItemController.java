package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.PedidoItem;
import com.issler.patrick.QoSystem.service.PedidoItemService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedidoItem")
public class PedidoItemController {

	@Autowired
	private PedidoItemService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<?> GetById(@RequestBody PedidoItem pedidoItem) {
		return service.buscar(pedidoItem);
	}

	@RequestMapping(value = "/buscar/pedido/mesa", method = RequestMethod.POST)
	public ResponseEntity<?> GetByMesa(@RequestBody PedidoItem pedidoItem) {
		return service.findAllByMesa(pedidoItem);
	}


	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody PedidoItem pedidoItem) {
		return service.save(pedidoItem);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody PedidoItem pedidoItem) {
		return service.delete(pedidoItem);
	}
}