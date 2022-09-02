package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.Pedido;
import com.issler.patrick.QoSystem.service.PedidoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ResponseEntity<?> GetById(@RequestBody Pedido pedido) {
		return service.buscar(pedido);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Pedido pedido) {
		return service.save(pedido);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Pedido pedido) {
		return service.delete(pedido);
	}
}