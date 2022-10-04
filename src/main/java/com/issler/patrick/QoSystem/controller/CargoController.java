package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import com.issler.patrick.QoSystem.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.Cargo;
import com.issler.patrick.QoSystem.service.CargoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cargo")
public class CargoController {

	@Autowired
	private CargoService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<?> GetById(@RequestBody Cargo cargo) {
		return service.buscar(cargo);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Cargo cargo) {
		return service.save(cargo);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Cargo cargo) {
		return service.delete(cargo);
	}

	@RequestMapping(value = "/buscar/empresa", method = RequestMethod.POST)
	public ResponseEntity<?> FindALL(@RequestBody Cargo cargo) {
		return service.findAllByEmpresa(cargo);
	}

}