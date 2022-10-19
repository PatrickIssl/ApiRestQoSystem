package com.issler.patrick.QoSystem.repository;

import com.issler.patrick.QoSystem.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.Pedido;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<List<Pedido>> findAllByStatusAndPessoa(int status, Pessoa pessoa);
}
