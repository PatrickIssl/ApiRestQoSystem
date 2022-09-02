package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.Pessoa;
import com.issler.patrick.QoSystem.service.PessoaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private PessoaService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ResponseEntity<?> GetById(@RequestBody Pessoa pessoa) {
		return service.buscar(pessoa);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Pessoa pessoa) {
		return service.save(pessoa);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Pessoa pessoa) {
		return service.delete(pessoa);
	}
}