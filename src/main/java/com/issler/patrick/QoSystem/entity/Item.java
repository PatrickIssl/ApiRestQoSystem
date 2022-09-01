package com.issler.patrick.QoSystem.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "item")
@Entity
@Component
@Getter @Setter @NoArgsConstructor
public class Item {	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Column(name = "nome")
	private String nome;
	
	@NotNull
	@Column(name = "valor")
	private double valor;
	
	@ManyToOne()
	private Empresa empresa;

	
}