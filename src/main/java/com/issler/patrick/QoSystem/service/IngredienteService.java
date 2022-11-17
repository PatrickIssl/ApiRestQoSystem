package com.issler.patrick.QoSystem.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Ingrediente;
import com.issler.patrick.QoSystem.repository.IngredienteRepository;

@Service
public class IngredienteService {

	@Autowired
	IngredienteRepository ingredienteRepository;

	@Autowired
	EmpresaRepository empresaRepository;

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

			ingrediente.setItems(null);
			return new ResponseEntity<Ingrediente>(ingredientes.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Ingrediente não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> findAllByEmpresa(Empresa empresa) {
		List<Ingrediente> listaIngrediente = ingredienteRepository.findAllByEmpresa(empresa);
		if(!listaIngrediente.isEmpty()){
			List<Ingrediente> ingredieteLista = new ArrayList<>();
			for(Ingrediente ingrediente : listaIngrediente){
				ingrediente.setItems(null);
				ingredieteLista.add(ingrediente);
			}

			return new ResponseEntity<>(ingredieteLista, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Lista de ingredientes vazia para essa empresa", HttpStatus.NOT_FOUND);
		}
	}


	public ResponseEntity<?> save(Ingrediente ingredientes) {
		Empresa empresa = empresaRepository.findById(ingredientes.getEmpresa().getId())
				.get();
		ingredientes.setEmpresa(empresa);
		ingredienteRepository.save(ingredientes);
		return new ResponseEntity<Ingrediente>(ingredientes, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {

		List<Ingrediente> listaIngrediente = ingredienteRepository.findAll();
		if(!listaIngrediente.isEmpty()){
			List<Ingrediente> ingredieteLista = new ArrayList<>();
			for(Ingrediente ingrediente : listaIngrediente){
				ingrediente.setItems(null);
				ingredieteLista.add(ingrediente);
			}

			return new ResponseEntity<>(ingredieteLista, HttpStatus.OK);
		}
 		return new ResponseEntity<>(listaIngrediente, HttpStatus.OK);
	}

	public ResponseEntity<?> listarPorAdicional(Boolean adicional) {
		List<Ingrediente> listaIngrediente = ingredienteRepository.findAllByAdicional(adicional);
		if(!listaIngrediente.isEmpty()){
			List<Ingrediente> ingredieteLista = new ArrayList<>();
			for(Ingrediente ingrediente : listaIngrediente){
				ingrediente.setItems(null);
				ingredieteLista.add(ingrediente);
			}

			return new ResponseEntity<>(ingredieteLista, HttpStatus.OK);
		}
		return new ResponseEntity<>(listaIngrediente, HttpStatus.OK);
	}
}
