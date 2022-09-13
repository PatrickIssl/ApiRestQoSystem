package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.Categoria;
import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.service.CategoriaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<?> GetById(@RequestBody Categoria categoria) {
		return service.buscar(categoria);
	}

	@RequestMapping(value = "/buscar/empresa", method = RequestMethod.POST)
	public ResponseEntity<?> FindALL(@RequestBody Empresa empresa) {
		return service.findAllByEmpresa(empresa);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Categoria categoria) {
		return service.save(categoria);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Categoria categoria) {
		return service.delete(categoria);
	}
}