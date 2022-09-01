package com.issler.patrick.QoSystem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pedido_item")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class PedidoItem {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "quantidade")
	private int quantidade;

    @ManyToOne()
	private Pedido pedido;

    @ManyToOne()
	private Item item;
    
}