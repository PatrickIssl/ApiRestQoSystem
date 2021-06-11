package com.issler.patrick.QoSystem.controller;

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

import com.issler.patrick.QoSystem.entity.Adicional;
import com.issler.patrick.QoSystem.repository.AdicionalRepository;


@RestController
@RequestMapping("/adicional")
public class AdicionalController {
    @Autowired
    private AdicionalRepository adicionalRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Adicional> Get() {
        return adicionalRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Adicional> GetById(@PathVariable(value = "id") long id)
    {
    	
        Optional<Adicional> adicional = adicionalRepository.findById(id);
        if(adicional.isPresent())
            return new ResponseEntity<Adicional>(adicional.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cadastrar", method =  RequestMethod.POST)
    public Adicional Post(@Valid @RequestBody Adicional adicional)
    {
        return adicionalRepository.save(adicional);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Adicional> adicional= adicionalRepository.findById(id);
        if(adicional.isPresent()){
            adicionalRepository.delete(adicional.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}