package com.issler.patrick.QoSystem.service;

import java.util.List;
import java.util.Optional;

import com.issler.patrick.QoSystem.repository.EmpresaRepository;
import com.issler.patrick.QoSystem.entity.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Cargo;
import com.issler.patrick.QoSystem.repository.CargoRepository;

@Service
public class CargoService {

	@Autowired
	CargoRepository cargoRepository;

	@Autowired
	EmpresaRepository empresaRepository;

	public ResponseEntity<String> delete(Cargo cargos) {
		Optional<Cargo> cargo = cargoRepository.findById(cargos.getId());
		if (cargo.isPresent()) {
			cargoRepository.delete(cargo.get());
			return new ResponseEntity<>("Cargo deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cargo não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Cargo cargo) {
		Optional<Cargo> cargos = cargoRepository.findById(cargo.getId());
		if (cargos.isPresent()) {
			return new ResponseEntity<Cargo>(cargos.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cargo não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> findAllByEmpresa(Empresa empresa) {
		List<Cargo> cargos = cargoRepository.findAllByEmpresa(empresa);
		if (!cargos.isEmpty()) {
			return new ResponseEntity<>(cargos, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Lista de cargos vazia para essa empresa", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Cargo cargos) {
		Empresa empresa = empresaRepository.findById(cargos.getEmpresa().getId())
				.get();
		cargos.setEmpresa(empresa);
		cargoRepository.save(cargos);
		return new ResponseEntity<Cargo>(cargos, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(cargoRepository.findAll(), HttpStatus.OK);
	}

}
