package com.issler.patrick.QoSystem.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;

	@JsonIgnore
	@OneToMany(mappedBy = "pedidoItem", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Adicional> adicionais;
}