package com.issler.patrick.QoSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.Conta;
import com.issler.patrick.QoSystem.entity.Pessoa;


@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> { 

	Optional<Pessoa> findByConta(Conta conta);
	
}
