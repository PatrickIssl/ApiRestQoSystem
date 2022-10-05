package com.issler.patrick.QoSystem.repository;

import com.issler.patrick.QoSystem.entity.Mesa;
import com.issler.patrick.QoSystem.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {

    List<Mesa> findAllByEmpresa(Empresa empresa);

}
