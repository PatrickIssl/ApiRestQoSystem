package com.issler.patrick.QoSystem.service;

import com.issler.patrick.QoSystem.entity.Remover;
import com.issler.patrick.QoSystem.repository.RemoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RemoverService {

	@Autowired
	RemoverRepository removerRepository;

	public ResponseEntity<String> delete(Remover removers) {
		Optional<Remover> remover = removerRepository.findById(removers.getId());
		if (remover.isPresent()) {
			removerRepository.delete(remover.get());
			return new ResponseEntity<>("Remover deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Remover não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Remover remover) {
		Optional<Remover> removerBusca = removerRepository.findById(remover.getId());
		if (removerBusca.isPresent()) {
			return new ResponseEntity<Remover>(removerBusca.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Remover não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Remover removerBusca) {
		removerRepository.save(removerBusca);
		return new ResponseEntity<Remover>(removerBusca, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(removerRepository.findAll(), HttpStatus.OK);
	}

}
