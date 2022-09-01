package com.issler.patrick.QoSystem.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "cargo")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class Cargo {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "conta")
	private String conta;
	
	@NotNull
	@Column(name = "senha")
	private String senha;
	
	
}