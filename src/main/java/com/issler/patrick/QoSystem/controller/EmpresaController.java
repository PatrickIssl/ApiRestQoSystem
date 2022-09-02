package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.service.EmpresaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ResponseEntity<?> GetById(@RequestBody Empresa empresa) {
		return service.buscar(empresa);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Empresa empresa) {
		return service.save(empresa);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Empresa empresa) {
		return service.delete(empresa);
	}
}