package com.issler.patrick.QoSystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.Conta;


@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> { 
	
	Optional<Conta> findByContaAndSenha(String conta, String senha);
	
}
