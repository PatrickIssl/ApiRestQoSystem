package com.issler.patrick.QoSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Categoria;
import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.repository.CategoriaRepository;
import com.issler.patrick.QoSystem.repository.EmpresaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	@Autowired
	EmpresaService empresaService;

	@Autowired
	EmpresaRepository empresaRepository;

	public ResponseEntity<String> delete(Categoria categorias) {
		Optional<Categoria> categoria = categoriaRepository.findById(categorias.getId());
		if (categoria.isPresent()) {
			categoriaRepository.delete(categoria.get());
			return new ResponseEntity<>("Categoria deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Categoria não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Categoria categoria) {
		Optional<Categoria> categorias = categoriaRepository.findById(categoria.getId());
		if (categorias.isPresent()) {
			return new ResponseEntity<Categoria>(categorias.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Categoria não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> findAllByEmpresa(Empresa empresa) {
		List<Categoria> categorias = categoriaRepository.findAllByEmpresa(empresa);
		if (!categorias.isEmpty()) {
			return new ResponseEntity<>(categorias, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Lista de categorias vazia para essa empresa", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Categoria categorias) {
		Empresa empresa = empresaRepository.findById(categorias.getEmpresa().getId())
						.get();
		categorias.setEmpresa(empresa);
		categoriaRepository.save(categorias);
		return new ResponseEntity<Categoria>(categorias, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(categoriaRepository.findAll(), HttpStatus.OK);
	}

}
