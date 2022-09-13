package com.issler.patrick.QoSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	List<Conta> findAllByContaAndSenha(String conta, String senha);

	List<Conta> findAllByConta(String conta);

}
