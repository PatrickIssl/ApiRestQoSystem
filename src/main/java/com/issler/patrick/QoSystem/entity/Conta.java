package com.issler.patrick.QoSystem.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "conta")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class Conta {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "conta")
	private String conta;
	
	@NotNull
	@Column(name = "senha")
	private String senha;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pessoa_id", referencedColumnName = "id")
	private Pessoa pessoa;
	
}