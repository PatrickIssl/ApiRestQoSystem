package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import com.issler.patrick.QoSystem.entity.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.issler.patrick.QoSystem.entity.PedidoItem;
import com.issler.patrick.QoSystem.service.PedidoItemService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

	@RequestMapping(value = "/buscar/pedido", method = RequestMethod.POST)
	public ResponseEntity<?> getByPedido(@RequestBody PedidoItem pedidoItem) {
		return service.findAllByPedido(pedidoItem.getPedido());
	}


	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody PedidoItem pedidoItem) {
		return service.save(pedidoItem);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody PedidoItem pedidoItem) {
		return service.delete(pedidoItem);
	}

	@RequestMapping(value = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> Put(@Valid @RequestBody PedidoItem pedidoItem) {
		return service.put(pedidoItem);
	}
}