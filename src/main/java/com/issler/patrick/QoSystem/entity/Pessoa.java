package com.issler.patrick.QoSystem.entity;


import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pessoa")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class Pessoa {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 100, name = "nome")
	private String nome;
	
	@Column(length = 11, name = "cpf")
	private String cpf;
	
	@Column( name = "data_nascimento")
	private Date dataNascimento;

	@Column( name = "salario")
	private Double salario;

	@Column(length = 60, name = "genero")
	private String genero;
	
	@Column(length = 20, name = "telefone")
	private String telefone;
	
    @OneToOne()
	@JoinColumn(name = "conta_id")
	private Conta conta;


    @ManyToOne()
	@JoinColumn(name = "cargo_id")
	private Cargo cargo;
    
	@OneToOne()
    @JoinColumn(name = "endereco_id")
	private Endereco endereco;

	@JsonIgnore
	@OneToMany(mappedBy = "pessoa")
	private List<Pedido> pedidos;

}