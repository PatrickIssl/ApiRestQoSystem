package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.Adicional;
import com.issler.patrick.QoSystem.service.AdicionalService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/adicional")
public class AdicionalController {

	@Autowired
	private AdicionalService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ResponseEntity<?> GetById(@RequestBody Adicional adicional) {
		return service.buscar(adicional);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Adicional adicional) {
		return service.save(adicional);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Adicional adicional) {
		return service.delete(adicional);
	}
}