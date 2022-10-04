package com.issler.patrick.QoSystem.service;

import java.util.List;
import java.util.Optional;

import com.issler.patrick.QoSystem.entity.Cargo;
import com.issler.patrick.QoSystem.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Ingrediente;
import com.issler.patrick.QoSystem.controller.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	IngredienteRepository ingredienteRepository;

	public ResponseEntity<String> delete(Ingrediente ingredientes) {
		Optional<Ingrediente> ingrediente = ingredienteRepository.findById(ingredientes.getId());
		if (ingrediente.isPresent()) {
			ingredienteRepository.delete(ingrediente.get());
			return new ResponseEntity<>("Ingrediente deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Ingrediente não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Ingrediente ingrediente) {
		Optional<Ingrediente> ingredientes = ingredienteRepository.findById(ingrediente.getId());
		if (ingredientes.isPresent()) {
			return new ResponseEntity<Ingrediente>(ingredientes.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Ingrediente não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> findAllByEmpresa(Empresa empresa) {
		List<Ingrediente> ingredientes = ingredienteRepository.findAllByEmpresa(empresa);
		if (!ingredientes.isEmpty()) {
			return new ResponseEntity<>(ingredientes, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Lista de ingredientes vazia para essa empresa", HttpStatus.NOT_FOUND);
		}
	}


	public ResponseEntity<?> save(Ingrediente ingredientes) {
		ingredienteRepository.save(ingredientes);
		return new ResponseEntity<Ingrediente>(ingredientes, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(ingredienteRepository.findAll(), HttpStatus.OK);
	}

}
