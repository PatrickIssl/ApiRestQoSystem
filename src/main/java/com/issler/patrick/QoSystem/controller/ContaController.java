package com.issler.patrick.QoSystem.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.Conta;
import com.issler.patrick.QoSystem.service.ContaService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/conta")
public class ContaController {

	@Autowired
	private ContaService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<?> GetByContaAndSenha(@RequestBody Conta conta) {
		return service.buscar(conta);
	}
	@RequestMapping(value = "/buscarID", method = RequestMethod.POST)
	public ResponseEntity<?> GetById(@RequestBody Conta conta) {
		return service.buscarId(conta);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Conta conta) {
		return service.save(conta);
	}

	@RequestMapping(value = "/editar", method = RequestMethod.PUT)
	public ResponseEntity<?> Put(@Valid @RequestBody Conta conta) {
		return service.put(conta);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Conta conta) {
		return service.delete(conta);
	}

	@RequestMapping(value = "/recuperar", method = RequestMethod.POST)
	public ResponseEntity<?> recuperar(@Valid @RequestBody Optional<Conta> conta) {
		return service.recuperar(conta);
	}
}