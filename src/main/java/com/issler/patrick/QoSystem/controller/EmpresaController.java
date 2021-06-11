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
import com.issler.patrick.QoSystem.entity.Empresa;
import com.issler.patrick.QoSystem.repository.EmpresaRepository;


@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaRepository empresaRepository;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Empresa> Get() {
        return empresaRepository.findAll();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Empresa> GetById(@PathVariable(value = "id") long id)
    {
    	
        Optional<Empresa> empresa = empresaRepository.findById(id);
        if(empresa.isPresent())
            return new ResponseEntity<Empresa>(empresa.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/cadastrar", method =  RequestMethod.POST)
    public Empresa Post(@Valid @RequestBody Empresa empresa)
    {
        return empresaRepository.save(empresa);
    }

    @RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Empresa> empresa= empresaRepository.findById(id);
        if(empresa.isPresent()){
        	empresaRepository.delete(empresa.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}