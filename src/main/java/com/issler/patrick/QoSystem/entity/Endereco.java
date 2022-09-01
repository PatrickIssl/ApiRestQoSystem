package com.issler.patrick.QoSystem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "endereco")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class Endereco {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "rua", length = 155)
	private String rua;
	
	@NotNull
	@Column(name = "bairro", length = 155)
	private String bairro;
	
	@NotNull
	@Column(name = "numero", length = 155)
	private String numero;
	
	@NotNull
	@Column(name = "uf", length = 2)
	private String uf;
	
	@NotNull
	@Column(name = "pais", length = 155)
	private String pais;
	
	@NotNull
	@Column(name = "observacao", length = 155)
	private String observacao;
	
    @OneToOne(mappedBy = "endereco")
 	private Pessoa pessoa;
    
    @OneToOne(mappedBy = "endereco")
 	private Empresa empresa;
	
}