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

@Table(name = "pedido")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class Pedido {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "status")
	private int status;

	@Column(length = 255, name = "observacao")
	private String observacao;

	@Column(length = 255, name = "retirar")
	private String retirar;

	@Column(name = "dividir")
	private int dividir;

	@Column(length = 255, name = "endereco_entrega")
	private String enderecoEntrega;
	
    @ManyToOne()
	private Pessoa pessoa;
    
	
}