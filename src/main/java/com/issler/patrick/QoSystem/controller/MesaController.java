package com.issler.patrick.QoSystem.controller;

import com.issler.patrick.QoSystem.entity.Mesa;
import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.service.MesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mesa")
public class MesaController {

	@Autowired
	private MesaService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<?> GetById(@RequestBody Mesa mesa) {
		return service.buscar(mesa);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Mesa mesa) {
		return service.save(mesa);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Mesa mesa) {
		return service.delete(mesa);
	}

	@RequestMapping(value = "/buscar/empresa", method = RequestMethod.POST)
	public ResponseEntity<?> FindALL(@RequestBody Empresa empresa) {
		return service.findAllByEmpresa(empresa);
	}

}