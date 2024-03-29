package com.issler.patrick.QoSystem.entity;


import javax.persistence.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne(cascade=CascadeType.PERSIST )
	@JoinColumn(name = "ingrediente_id")
	private Ingrediente ingrediente;

	@JsonIgnore
	@ManyToOne(cascade=CascadeType.PERSIST )
	@JoinColumn(name = "pedidoitem_id")
	private PedidoItem pedidoItem;
    
}