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

import com.issler.patrick.QoSystem.entity.Ingrediente;
import com.issler.patrick.QoSystem.repository.IngredienteRepository;


@RestController
@RequestMapping("/ingrediente")
public class IngredienteController {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Ingrediente> Get() {
        return ingredienteRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ingrediente> GetById(@PathVariable(value = "id") long id)
    {
    	
        Optional<Ingrediente> ingrediente = ingredienteRepository.findById(id);
        if(ingrediente.isPresent())
            return new ResponseEntity<Ingrediente>(ingrediente.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cadastrar", method =  RequestMethod.POST)
    public Ingrediente Post(@Valid @RequestBody Ingrediente ingrediente)
    {
        return ingredienteRepository.save(ingrediente);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Ingrediente> ingrediente= ingredienteRepository.findById(id);
        if(ingrediente.isPresent()){
            ingredienteRepository.delete(ingrediente.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}