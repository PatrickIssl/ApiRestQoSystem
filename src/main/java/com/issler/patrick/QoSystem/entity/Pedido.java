package com.issler.patrick.QoSystem.entity;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
	@JoinColumn(name = "pessoa_id")
	private Pessoa pessoa;

	@JsonIgnore
	@OneToMany(mappedBy = "pedido")
	private List<PedidoItem> pedidoItems;

}