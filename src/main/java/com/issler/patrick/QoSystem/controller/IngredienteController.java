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
import org.springframework.web.bind.annotation.PathVariable;
import com.issler.patrick.QoSystem.entity.Ingrediente;
import com.issler.patrick.QoSystem.service.IngredienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {

	@Autowired
	private IngredienteService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<?> GetById(@RequestBody Ingrediente ingrediente) {
		return service.buscar(ingrediente);
	}

	@RequestMapping(value = "/listar/{adicional}", method = RequestMethod.POST)
	public ResponseEntity<?> GetById(@PathVariable Boolean adicional) {
		return service.listarPorAdicional(adicional);
	}


	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Ingrediente ingrediente) {
		return service.save(ingrediente);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Ingrediente ingrediente) {
		return service.delete(ingrediente);
	}

	@RequestMapping(value = "/buscar/empresa", method = RequestMethod.POST)
	public ResponseEntity<?> FindALL(@RequestBody Empresa empresa) {
		return service.findAllByEmpresa(empresa);
	}

	@RequestMapping(value = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> Put(@Valid @RequestBody Ingrediente ingrediente) {
		return service.put(ingrediente);
	}

}