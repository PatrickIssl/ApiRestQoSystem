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

import com.issler.patrick.QoSystem.entity.PedidoItem;
import com.issler.patrick.QoSystem.repository.PedidoItemRepository;


@RestController
@RequestMapping("/pedidoItem")
public class PedidoItemController {
    @Autowired
    private PedidoItemRepository pedidoItemRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<PedidoItem> Get() {
        return pedidoItemRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<PedidoItem> GetById(@PathVariable(value = "id") long id)
    {
    	
        Optional<PedidoItem> pedidoItem = pedidoItemRepository.findById(id);
        if(pedidoItem.isPresent())
            return new ResponseEntity<PedidoItem>(pedidoItem.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cadastrar", method =  RequestMethod.POST)
    public PedidoItem Post(@Valid @RequestBody PedidoItem pedidoItem)
    {
        return pedidoItemRepository.save(pedidoItem);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<PedidoItem> pedidoItem= pedidoItemRepository.findById(id);
        if(pedidoItem.isPresent()){
            pedidoItemRepository.delete(pedidoItem.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}