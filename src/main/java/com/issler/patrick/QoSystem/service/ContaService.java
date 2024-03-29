package com.issler.patrick.QoSystem.service;

import java.util.List;
import java.util.Optional;

import com.issler.patrick.QoSystem.entity.Endereco;
import com.issler.patrick.QoSystem.repository.CargoRepository;
import com.issler.patrick.QoSystem.entity.Cargo;
import com.issler.patrick.QoSystem.repository.EnderecoRepository;
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

	@Autowired
	CargoRepository cargoRepository;

	@Autowired
	EnderecoRepository enderecoRepository;


	public ResponseEntity<String> delete(Conta contas) {
		Optional<Conta> conta = contaRepository.findById(contas.getId());
		if (conta.isPresent()) {
			if(conta.get().getPessoa().getPedidos() != null){
				return new ResponseEntity<>("Conta vinculada a pedidos", HttpStatus.BAD_REQUEST);
			}
			conta.get().getPessoa().setCargo(null);
			contaRepository.delete(conta.get());
			return new ResponseEntity<>("Conta deletado com sucesso", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Conta não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscarId(Conta conta) {
		Optional<Conta> contas = contaRepository.findById(conta.getId());
		if (contas.isPresent()) {
			return new ResponseEntity<Conta>(contas.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Conta não encontrada", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> buscar(Conta conta) {
		List<Conta> contas = contaRepository.findAllByContaIgnoreCaseAndSenha(conta.getConta(), conta.getSenha());
		if (!contas.isEmpty()) {
			return new ResponseEntity<>(contas, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Conta não encontrado", HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<?> save(Conta contas) {
		if(contas.getPessoa() != null) {
			if(contas.getPessoa().getCargo() != null){
			Optional<Cargo> cargo = cargoRepository.findById(contas.getPessoa().getCargo().getId());
			if(cargo.isPresent()) {
				contas.getPessoa().setCargo(cargo.get());
			}}
			if(contas.getPessoa().getEndereco() != null){
			Optional<Endereco> endereco = enderecoRepository.findById(contas.getPessoa().getEndereco().getId());
			if(endereco.isPresent()){
				contas.getPessoa().setEndereco(endereco.get());
			}}
		}
		if (!contaRepository.findAllByContaIgnoreCase(contas.getConta()).isEmpty()) {
			return new ResponseEntity<>("Email já está em uso", HttpStatus.BAD_REQUEST);
		}
		contaRepository.save(contas);
		return new ResponseEntity<Conta>(contas, HttpStatus.OK);
	}

	public ResponseEntity<?> put(Conta contas) {
		Optional<Conta> conta = contaRepository.findById(contas.getId());
		if(contas.getSenha().length() < 1){
			return new ResponseEntity<>("Sua senha tem que ter mais de 6 caracteres", HttpStatus.BAD_REQUEST);
		}
		if (conta.isPresent()) {
			if(contas.getPessoa().getCargo().getId()!= null){
				Optional<Cargo> cargo =  cargoRepository.findById(contas.getPessoa().getCargo().getId());
				if(cargo.isPresent()){
					conta.get().getPessoa().setCargo(cargo.get());
				}
			}
			if(contas.getPessoa().getImagem() != null){
				conta.get().getPessoa().setImagem(contas.getPessoa().getImagem());
			}
			if(contas.getPessoa().getNome() != null){
				conta.get().getPessoa().setNome(contas.getPessoa().getNome());
			}
			if(contas.getPessoa().getSalario() != null){
				conta.get().getPessoa().setSalario(contas.getPessoa().getSalario());
			}
			contas.setPessoa(conta.get().getPessoa());


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
