package com.issler.patrick.QoSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Pessoa;
import com.issler.patrick.QoSystem.repository.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	PessoaRepository pessoaRepository;

	public ResponseEntity<String> delete(Pessoa pessoas) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(pessoas.getId());
		if (pessoa.isPresent()) {
			pessoaRepository.delete(pessoa.get());
			return new ResponseEntity<>("Pessoa deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Pessoa não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Pessoa pessoa) {
		Optional<Pessoa> pessoas = pessoaRepository.findById(pessoa.getId());
		if (pessoas.isPresent()) {
			return new ResponseEntity<Pessoa>(pessoas.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Pessoa não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Pessoa pessoas) {
		pessoaRepository.save(pessoas);
		return new ResponseEntity<Pessoa>(pessoas, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(pessoaRepository.findAll(), HttpStatus.OK);
	}

}
