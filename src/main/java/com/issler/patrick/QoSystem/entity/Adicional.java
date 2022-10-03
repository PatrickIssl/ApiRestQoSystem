package com.issler.patrick.QoSystem.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "adicional")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class Adicional {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "quantidade")
	private int quantidade;

	@JsonBackReference
    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "ingrediente_id")
	private Ingrediente ingrediente;

	@JsonBackReference
    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "pedidoitem_id")
	private PedidoItem pedidoItem;
    
}