package com.issler.patrick.QoSystem.service;

import com.issler.patrick.QoSystem.entity.Mesa;
import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.repository.MesaRepository;
import com.issler.patrick.QoSystem.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MesaService {

	@Autowired
	MesaRepository mesaRepository;

	@Autowired
	EmpresaRepository empresaRepository;

	public ResponseEntity<String> delete(Mesa mesas) {
		Optional<Mesa> mesa = mesaRepository.findById(mesas.getId());
		if (mesa.isPresent()) {
			mesaRepository.delete(mesa.get());
			return new ResponseEntity<>("Mesa deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Mesa não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Mesa mesa) {
		Optional<Mesa> mesas = mesaRepository.findById(mesa.getId());
		if (mesas.isPresent()) {
			return new ResponseEntity<Mesa>(mesas.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Mesa não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> findAllByEmpresa(Empresa empresa) {
		List<Mesa> mesas = mesaRepository.findAllByEmpresa(empresa);
		if (!mesas.isEmpty()) {
			return new ResponseEntity<>(mesas, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Lista de mesas vazia para essa empresa", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Mesa mesas) {
		Empresa empresa = empresaRepository.findById(mesas.getEmpresa().getId())
				.get();
		mesas.setEmpresa(empresa);
		mesaRepository.save(mesas);
		return new ResponseEntity<Mesa>(mesas, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(mesaRepository.findAll(), HttpStatus.OK);
	}

}
