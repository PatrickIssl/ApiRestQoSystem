package com.issler.patrick.QoSystem.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.email.EnviaMfa;
import com.issler.patrick.QoSystem.entity.Conta;
import com.issler.patrick.QoSystem.entity.Pessoa;
import com.issler.patrick.QoSystem.metodos.GerarMfa;
import com.issler.patrick.QoSystem.repository.ContaRepository;
import com.issler.patrick.QoSystem.repository.PessoaRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ContaRepository contaRepository;
    
    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Pessoa> Get() {
        return pessoaRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{conta}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "conta") Conta conta)
    {
        Optional<Pessoa> pessoa = pessoaRepository.findByConta(conta);
        if(pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "id") long id)
    {
    	
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        if(pessoa.isPresent())
            return new ResponseEntity<Pessoa>(pessoa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value = "/buscar/{conta}/{senha}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> GetByContaAndSenha(@PathVariable(value = "conta") String conta, @PathVariable(value = "senha") String senha)
    {
        Optional<Conta> contaRetorno = contaRepository.findByContaAndSenha(conta, senha);
        if(contaRetorno.isPresent()) {
        	Optional<Pessoa> pessoaRetorno = pessoaRepository.findByConta(contaRetorno.get());
        	if(pessoaRetorno.isPresent()) {
        		contaRetorno.get().setMfa(GerarMfa.gerarMfa().toUpperCase());
        		EnviaMfa.notificaPorEmail(contaRetorno.get().getMfa(), pessoaRetorno.get());
        	}
            return new ResponseEntity<Pessoa>(pessoaRetorno.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/cadastrar", method =  RequestMethod.POST)
    public Pessoa Post(@Valid @RequestBody Pessoa pessoa)
    {
        return pessoaRepository.save(pessoa);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Pessoa> pessoa= pessoaRepository.findById(id);
        if(pessoa.isPresent()){
            pessoaRepository.delete(pessoa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}