package com.issler.patrick.QoSystem.entity;


import javax.persistence.*;

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
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "quantidade")
	private int quantidade;

    @ManyToOne()
	@JoinColumn(name = "ingrediente_id")
	private Ingrediente ingrediente;

    @ManyToOne()
	@JoinColumn(name = "pedidoitem_id")
	private PedidoItem pedidoItem;
    
}