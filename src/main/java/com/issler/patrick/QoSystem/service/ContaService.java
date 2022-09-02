package com.issler.patrick.QoSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Conta;
import com.issler.patrick.QoSystem.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	ContaRepository contaRepository;

	public ResponseEntity<String> delete(Conta contas) {
		Optional<Conta> conta = contaRepository.findById(contas.getId());
		if (conta.isPresent()) {
			contaRepository.delete(conta.get());
			return new ResponseEntity<>("Conta deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Conta não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Conta conta) {
		Optional<Conta> contas = contaRepository.findById(conta.getId());
		if (contas.isPresent()) {
			return new ResponseEntity<Conta>(contas.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Conta não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Conta contas) {
		contaRepository.save(contas);
		return new ResponseEntity<Conta>(contas, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(contaRepository.findAll(), HttpStatus.OK);
	}

}
