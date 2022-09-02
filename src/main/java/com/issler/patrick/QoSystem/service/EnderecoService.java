package com.issler.patrick.QoSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Endereco;
import com.issler.patrick.QoSystem.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	EnderecoRepository enderecoRepository;

	public ResponseEntity<String> delete(Endereco enderecos) {
		Optional<Endereco> endereco = enderecoRepository.findById(enderecos.getId());
		if (endereco.isPresent()) {
			enderecoRepository.delete(endereco.get());
			return new ResponseEntity<>("Endereco deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Endereco não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Endereco endereco) {
		Optional<Endereco> enderecos = enderecoRepository.findById(endereco.getId());
		if (enderecos.isPresent()) {
			return new ResponseEntity<Endereco>(enderecos.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Endereco não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Endereco enderecos) {
		enderecoRepository.save(enderecos);
		return new ResponseEntity<Endereco>(enderecos, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(enderecoRepository.findAll(), HttpStatus.OK);
	}

}
