package com.issler.patrick.QoSystem.repository;

import com.issler.patrick.QoSystem.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.Ingrediente;

import java.util.List;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {

    List<Ingrediente> findAllByEmpresa(Empresa empresa);
}
