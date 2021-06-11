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

import com.issler.patrick.QoSystem.entity.Cargo;
import com.issler.patrick.QoSystem.repository.CargoRepository;


@RestController
@RequestMapping("/cargo")
public class CargoController {
    @Autowired
    private CargoRepository cargoRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Cargo> Get() {
        return cargoRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Cargo> GetById(@PathVariable(value = "id") long id)
    {
    	
        Optional<Cargo> cargo = cargoRepository.findById(id);
        if(cargo.isPresent())
            return new ResponseEntity<Cargo>(cargo.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cadastrar", method =  RequestMethod.POST)
    public Cargo Post(@Valid @RequestBody Cargo cargo)
    {
        return cargoRepository.save(cargo);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Cargo> cargo= cargoRepository.findById(id);
        if(cargo.isPresent()){
            cargoRepository.delete(cargo.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}