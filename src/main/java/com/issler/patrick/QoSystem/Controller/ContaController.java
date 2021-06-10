package com.issler.patrick.QoSystem.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.issler.patrick.QoSystem.entity.Conta;
import com.issler.patrick.QoSystem.repository.ContaRepository;


@RestController
public class ContaController {
    @Autowired
    private ContaRepository contaRepository;

    @RequestMapping(value = "/conta", method = RequestMethod.GET)
    public List<Conta> Get() {
        return contaRepository.findAll();
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.GET)
    public ResponseEntity<Conta> GetById(@PathVariable(value = "id") long id)
    {
    	
        Optional<Conta> conta = contaRepository.findById(id);
        if(conta.isPresent())
            return new ResponseEntity<Conta>(conta.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/conta", method =  RequestMethod.POST)
    public Conta Post(@Valid @RequestBody Conta conta)
    {
        return contaRepository.save(conta);
    }

    @RequestMapping(value = "/conta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Conta> conta= contaRepository.findById(id);
        if(conta.isPresent()){
            contaRepository.delete(conta.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}