package com.issler.patrick.QoSystem.controller;

import com.issler.patrick.QoSystem.entity.Adicional;
import com.issler.patrick.QoSystem.entity.Remover;
import com.issler.patrick.QoSystem.service.AdicionalService;
import com.issler.patrick.QoSystem.service.RemoverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/remover")
public class RemoverController {

	@Autowired
	private RemoverService service;

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ResponseEntity<?> Get() {
		return service.findAll();
	}

	@RequestMapping(value = "/buscar", method = RequestMethod.POST)
	public ResponseEntity<?> GetById(@RequestBody Remover remover) {
		return service.buscar(remover);
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ResponseEntity<?> Post(@Valid @RequestBody Remover remover) {
		return service.save(remover);
	}

	@RequestMapping(value = "/deletar", method = RequestMethod.DELETE)
	public ResponseEntity<?> Delete(@Valid @RequestBody Remover remover) {
		return service.delete(remover);
	}
}