package com.issler.patrick.QoSystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.Conta;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Long> {

	List<Conta> findAllByContaIgnoreCaseAndSenha(String conta, String senha);

	List<Conta> findAllByContaIgnoreCase(String conta);

}
