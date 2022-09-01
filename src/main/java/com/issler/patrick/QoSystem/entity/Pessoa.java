package com.issler.patrick.QoSystem.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
	
	@Column(length = 60, name = "genero")
	private String genero;
	
	@Column(length = 20, name = "telefone")
	private String telefone;
	
    @OneToOne(mappedBy = "pessoa")
	private Conta conta;
    
    @ManyToOne()
	private Cargo cargo;
    
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco_id", referencedColumnName = "id")
	private Endereco endereco;
	
}