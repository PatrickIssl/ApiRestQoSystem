package com.issler.patrick.QoSystem.service;

import java.util.List;
import java.util.Optional;

import com.issler.patrick.QoSystem.entity.Adicional;
import com.issler.patrick.QoSystem.entity.Mesa;
import com.issler.patrick.QoSystem.entity.Pessoa;
import com.issler.patrick.QoSystem.repository.MesaRepository;
import com.issler.patrick.QoSystem.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.issler.patrick.QoSystem.entity.Pedido;
import com.issler.patrick.QoSystem.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	@Autowired
	PessoaRepository pessoaRepository;

	@Autowired
	MesaRepository mesaRepository;

	public ResponseEntity<String> delete(Pedido pedidos) {
		Optional<Pedido> pedido = pedidoRepository.findById(pedidos.getId());
		if (pedido.isPresent()) {
			pedidoRepository.delete(pedido.get());
			return new ResponseEntity<>("Pedido deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Pedido não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Pedido pedido) {
		Optional<Pedido> pedidos = pedidoRepository.findById(pedido.getId());
		if (pedidos.isPresent()) {
			return new ResponseEntity<Pedido>(pedidos.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Pedido não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Pedido pedidos) {
		Optional<Pessoa>  pessoa = pessoaRepository.findById(pedidos.getPessoa().getId());
		if (!pessoa.isPresent()){
			return new ResponseEntity<>("Pessoa não encontrada", HttpStatus.NOT_FOUND);
		}
		Optional<Mesa>  mesa = mesaRepository.findById(pedidos.getMesa().getId());
		if (!mesa.isPresent()){
			return new ResponseEntity<>("Mesa não encontrada", HttpStatus.NOT_FOUND);
		}
		pedidos.setMesa(mesa.get());
		pedidos.setPessoa(pessoa.get());
		pedidoRepository.save(pedidos);
		return new ResponseEntity<Pedido>(pedidos, HttpStatus.OK);
	}

	public ResponseEntity<?> findAll() {
		return new ResponseEntity<>(pedidoRepository.findAll(), HttpStatus.OK);
	}

	public ResponseEntity<?> put(Pedido pedidos) {
		Optional<Pedido> pedido = pedidoRepository.findById(pedidos.getId());
		if (pedido != null) {
			pedidoRepository.save(pedidos);
			return new ResponseEntity<Pedido>(pedidos, HttpStatus.OK);
		}
		return new ResponseEntity<>("Pedido não encontrado", HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<?> buscarPorStatusEPessoa(Pedido pedido) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(pedido.getPessoa().getId());
		if(pessoa.isPresent()){
			return new ResponseEntity<>(pedidoRepository.findAllByStatusAndPessoa(pedido.getStatus(), pedido.getPessoa()), HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Pessoa não encontrada", HttpStatus.NOT_FOUND);
		}
	}
}
