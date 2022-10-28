package com.issler.patrick.QoSystem.repository;

import com.issler.patrick.QoSystem.entity.Mesa;
import com.issler.patrick.QoSystem.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.issler.patrick.QoSystem.entity.PedidoItem;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoItemRepository extends JpaRepository<PedidoItem, Long> {

    List<PedidoItem> findAllByPedidoMesa(Mesa mesa);

    Optional<List<PedidoItem>> getAllByPedido(Optional<Pedido> pedidos);

    List<PedidoItem> findAllByPedidoMesaAndPedidoStatus(Mesa mesa, Integer status);
}
