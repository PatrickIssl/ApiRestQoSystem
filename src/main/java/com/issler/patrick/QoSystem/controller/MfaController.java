package com.issler.patrick.QoSystem.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.email.EnviaMfa;
import com.issler.patrick.QoSystem.entity.Conta;
import com.issler.patrick.QoSystem.entity.Pessoa;
import com.issler.patrick.QoSystem.repository.ContaRepository;
import com.issler.patrick.QoSystem.repository.PessoaRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/mfa")
public class MfaController {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private ContaRepository contaRepository;


    @RequestMapping(value = "/buscar/{mfa}/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pessoa> GetById(@PathVariable(value = "mfa") String mfa,@PathVariable(value = "id") long id)
    {
        Optional<Conta> contaRetorno = contaRepository.findById(id);
        Optional<Pessoa> pessoaRetorno = pessoaRepository.findByConta(contaRetorno.get());
        if(pessoaRetorno.isPresent()) {
        	EnviaMfa.notificaPorEmail(mfa, pessoaRetorno.get());
        	return new ResponseEntity<>(HttpStatus.OK);
    }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}