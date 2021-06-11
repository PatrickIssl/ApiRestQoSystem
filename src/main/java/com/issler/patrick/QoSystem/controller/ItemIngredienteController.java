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

import com.issler.patrick.QoSystem.entity.ItemIngrediente;
import com.issler.patrick.QoSystem.repository.ItemIngredienteRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/itemIngrediente")
public class ItemIngredienteController {
    @Autowired
    private ItemIngredienteRepository itemIngredienteRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<ItemIngrediente> Get() {
        return itemIngredienteRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<ItemIngrediente> GetById(@PathVariable(value = "id") long id)
    {
    	
        Optional<ItemIngrediente> itemIngrediente = itemIngredienteRepository.findById(id);
        if(itemIngrediente.isPresent())
            return new ResponseEntity<ItemIngrediente>(itemIngrediente.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cadastrar", method =  RequestMethod.POST)
    public ItemIngrediente Post(@Valid @RequestBody ItemIngrediente itemIngrediente)
    {
        return itemIngredienteRepository.save(itemIngrediente);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<ItemIngrediente> itemIngrediente= itemIngredienteRepository.findById(id);
        if(itemIngrediente.isPresent()){
            itemIngredienteRepository.delete(itemIngrediente.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}