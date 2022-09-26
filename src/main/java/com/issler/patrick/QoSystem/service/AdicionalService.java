package com.issler.patrick.QoSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Adicional;
import com.issler.patrick.QoSystem.controller.repository.AdicionalRepository;

@Service
public class AdicionalService {

	@Autowired
	AdicionalRepository adicionalRepository;

	public ResponseEntity<String> delete(Adicional adicionals) {
		Optional<Adicional> adicional = adicionalRepository.findById(adicionals.getId());
		if (adicional.isPresent()) {
			adicionalRepository.delete(adicional.get());
			return new ResponseEntity<>("Adicional deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Adicional não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Adicional adicional) {
		Optional<Adicional> adicionais = adicionalRepository.findById(adicional.getId());
		if (adicionais.isPresent()) {
			return new ResponseEntity<Adicional>(adicionais.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Adicional não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Adicional adicionais) {
		adicionalRepository.save(adicionais);
		return new ResponseEntity<Adicional>(adicionais, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(adicionalRepository.findAll(), HttpStatus.OK);
	}

}
