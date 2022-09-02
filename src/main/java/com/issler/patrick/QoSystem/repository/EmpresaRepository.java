package com.issler.patrick.QoSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
