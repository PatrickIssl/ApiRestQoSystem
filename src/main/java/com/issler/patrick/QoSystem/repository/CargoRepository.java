package com.issler.patrick.QoSystem.repository;

import com.issler.patrick.QoSystem.entity.Categoria;
import com.issler.patrick.QoSystem.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.Cargo;

import java.util.List;


@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

    List<Cargo> findAllByEmpresa(Empresa empresa);

}
