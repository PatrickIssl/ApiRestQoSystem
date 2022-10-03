package com.issler.patrick.QoSystem.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

	@JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;

	@JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "item_id")
	private Item item;

	@JsonManagedReference
	@OneToMany(mappedBy = "pedidoItem", cascade = CascadeType.ALL)
	private List<Adicional> adicionais;
}