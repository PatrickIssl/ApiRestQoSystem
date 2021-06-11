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

import com.issler.patrick.QoSystem.entity.Pedido;
import com.issler.patrick.QoSystem.repository.PedidoRepository;


@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Pedido> Get() {
        return pedidoRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pedido> GetById(@PathVariable(value = "id") long id)
    {
    	
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if(pedido.isPresent())
            return new ResponseEntity<Pedido>(pedido.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cadastrar", method =  RequestMethod.POST)
    public Pedido Post(@Valid @RequestBody Pedido pedido)
    {
        return pedidoRepository.save(pedido);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Pedido> pedido= pedidoRepository.findById(id);
        if(pedido.isPresent()){
            pedidoRepository.delete(pedido.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}