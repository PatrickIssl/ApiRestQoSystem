package com.issler.patrick.QoSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Conta;
import com.issler.patrick.QoSystem.repository.ContaRepository;

import net.bytebuddy.utility.RandomString;

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
		List<Conta> contas = contaRepository.findAllByContaAndSenha(conta.getConta(), conta.getSenha());
		if (!contas.isEmpty()) {
			return new ResponseEntity<>(contas, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Conta não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Conta contas) {
		if (!contaRepository.findAllByConta(contas.getConta()).isEmpty()) {
			return new ResponseEntity<>("Email já está em uso", HttpStatus.BAD_REQUEST);
		}
		contaRepository.save(contas);
		return new ResponseEntity<Conta>(contas, HttpStatus.OK);
	}

	public ResponseEntity<?> put(Conta contas) {
		Optional<Conta> conta = contaRepository.findById(contas.getId());
		if (conta != null && contas.getSenha().length() > 7) {
			contaRepository.save(contas);
			return new ResponseEntity<Conta>(contas, HttpStatus.OK);
		}
		return new ResponseEntity<>("Conta não encontrado", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(contaRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<?> recuperar(Optional<Conta> conta) {
		conta = contaRepository.findById(conta.get().getId());
		if (conta != null) {
			conta.get().setMfa(RandomString.make(6).toUpperCase());
			conta.get().setSenha(null);
			return new ResponseEntity<>(conta, HttpStatus.OK);
		}
		return new ResponseEntity<>("Conta não encontrado", HttpStatus.NOT_FOUND);
	}

}
