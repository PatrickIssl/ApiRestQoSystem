package com.issler.patrick.QoSystem.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.lang.Nullable;
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

	@Nullable
    @ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

    @ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "item_id")
	private Item item;

	@Column(length = 255, name = "observacao")
	private String observacao;


	@OneToMany(mappedBy = "pedidoItem", cascade = CascadeType.PERSIST)
	private List<Adicional> adicionais;
}