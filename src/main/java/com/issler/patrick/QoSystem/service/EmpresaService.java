package com.issler.patrick.QoSystem.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.repository.EmpresaRepository;

@Service
public class EmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;

	public ResponseEntity<String> delete(Empresa empresas) {
		Optional<Empresa> empresa = empresaRepository.findById(empresas.getId());
		if (empresa.isPresent()) {
			empresaRepository.delete(empresa.get());
			return new ResponseEntity<>("Empresa deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Empresa não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Empresa empresa) {
		Optional<Empresa> empresas = empresaRepository.findById(empresa.getId());
		if (empresas.isPresent()) {
			return new ResponseEntity<Empresa>(empresas.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Empresa não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Empresa empresas) {
		empresaRepository.save(empresas);
		return new ResponseEntity<Empresa>(empresas, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(empresaRepository.findAll(), HttpStatus.OK);
	}

}
