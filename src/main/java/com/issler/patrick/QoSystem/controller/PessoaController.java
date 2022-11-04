package com.issler.patrick.QoSystem.controller;

import javax.validation.Valid;

import com.issler.patrick.QoSystem.entity.Conta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.issler.patrick.QoSystem.entity.Pessoa;
import com.issler.patrick.QoSystem.service.PessoaService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

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

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
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
	@RequestMapping(value = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> Put(@Valid @RequestBody Pessoa pessoa) {
		return service.put(pessoa);
	}

}